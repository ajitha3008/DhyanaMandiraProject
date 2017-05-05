package com.braingalore.dhyanamandira.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.view.View;

import com.braingalore.dhyanamandira.Constants;

/**
 * Created by s92 on 5/4/2017.
 */

public class CallingUtils {
    public static boolean checkCallPermission(Context context) {
        String callPermission = Manifest.permission.CALL_PHONE;
        int hasPermission = ContextCompat.checkSelfPermission(context, callPermission);
        String[] permissions = new String[]{callPermission};
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, permissions, Constants.REQUEST_CALL_PHONE);
            return false;
        }
        return true;
    }

    public static boolean isSimPresent(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);  //gets the current TelephonyManager
        return !(tm.getSimState() == TelephonyManager.SIM_STATE_ABSENT);
    }

    public static void dialIntent(Context context, String number, View view) {
        if (checkCallPermission(context)) {
            //FirebaseCrash.log("Trying to call");
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
            context.startActivity(intent);
        } else {
            Snackbar.make(view, "Grant permission to make call", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
        }
    }
}
