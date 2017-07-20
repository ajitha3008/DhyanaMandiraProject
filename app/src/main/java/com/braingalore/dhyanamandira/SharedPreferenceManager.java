package com.braingalore.dhyanamandira;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by s92 on 7/20/2017.
 */

public class SharedPreferenceManager {

    private static SharedPreferenceManager mInstance;

    private static Context mContext;

    private SharedPreferences pref;

    public static void createInstance(Context context) {
        mContext = context;
        mInstance = new SharedPreferenceManager();
    }

    public static SharedPreferenceManager getInstance() {
        return mInstance;
    }

    public void createSharedPreferences() {
        pref = mContext.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setNotifContent(String data) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.KEY_SHARED_PREF_NOTIFICATION, data);
        editor.commit();
    }

    public String getNotifContent() {
        return pref.getString(Constants.KEY_SHARED_PREF_NOTIFICATION, "No notification!");
    }

    public void deleteSharedPreferencewithKey(String KEY_NAME) {
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(KEY_NAME);
        editor.commit();
    }

    public void deleteAllSharedPreference() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
