package com.braingalore.dhyanamandira;

import android.app.Application;

import com.google.firebase.FirebaseApp;

/**
 * Created by s92 on 5/4/2017.
 */

public class DhyanaMandira extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
