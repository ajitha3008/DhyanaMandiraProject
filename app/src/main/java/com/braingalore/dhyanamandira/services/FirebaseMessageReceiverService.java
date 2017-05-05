package com.braingalore.dhyanamandira.services;

import android.util.Log;

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
}
