package com.braingalore.dhyanamandira;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crash.FirebaseCrash;

/**
 * Created by s92 on 5/4/2017.
 */

public class DhyanaMandira extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
        FacebookSdk.sdkInitialize(this);
        SharedPreferenceManager.createInstance(this);
        SharedPreferenceManager.getInstance().createSharedPreferences();
        // Setup handler for uncaught exceptions.
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                handleUncaughtException(thread, e);
            }
        });
    }

    public void handleUncaughtException(Thread thread, Throwable e) {
        FirebaseCrash.report(new Exception("Default exception handler " + e.getMessage() + e.getStackTrace().toString()));
        System.exit(1); // kill off the crashed app
    }
}
