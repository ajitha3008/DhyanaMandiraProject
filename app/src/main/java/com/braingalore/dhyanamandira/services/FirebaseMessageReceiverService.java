package com.braingalore.dhyanamandira.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.braingalore.dhyanamandira.Constants;
import com.braingalore.dhyanamandira.HomeActivity;
import com.braingalore.dhyanamandira.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by s92 on 5/4/2017.
 */

public class FirebaseMessageReceiverService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i("info", "From: " + remoteMessage.getFrom());
        Log.i("info", "Notification Message Body: " + remoteMessage.getNotification().getBody());
    }

    @Override
    public void zzm(Intent intent) {
        Intent launchIntent = new Intent(this, HomeActivity.class);
        launchIntent.setAction(Constants.FIREBASE_ACTION);
        launchIntent.putExtra(Constants.FIREBASE_TITLE, intent.getStringExtra("gcm.notification.title"));
        launchIntent.putExtra(Constants.FIREBASE_BODY, intent.getStringExtra("gcm.notification.body"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, launchIntent,
                PendingIntent.FLAG_ONE_SHOT);
        Bitmap rawBitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher_round);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_notif_icon_firebase)
                .setLargeIcon(rawBitmap)
                .setContentTitle(intent.getStringExtra("gcm.notification.title"))
                .setContentText(intent.getStringExtra("gcm.notification.body"))
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = notificationBuilder.build();
        notification.flags |= Notification.FLAG_NO_CLEAR;

        notificationManager.notify(0 /* ID of notification */, notification);
    }
}
