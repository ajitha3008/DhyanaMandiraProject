package com.braingalore.dhyanamandira;

import android.Manifest;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.braingalore.dhyanamandira.fragments.AboutFragment;
import com.braingalore.dhyanamandira.fragments.CostFragment;
import com.google.firebase.crash.FirebaseCrash;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_CALL_PHONE = 1234;
    FragmentManager fm ;
    FragmentTransaction fragmentTransaction ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //for testing
        //FirebaseCrash.log("Activity created");
        //FirebaseCrash.logcat(Log.ERROR, "ajitha", "No error");
        //FirebaseCrash.report(new Exception("My first Android non-fatal error"));

        fm = getFragmentManager();

        fragmentTransaction = fm.beginTransaction();
        AboutFragment f1 = new AboutFragment();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSimPresent(HomeActivity.this)) {
                    if (checkCallPermission()) {
                        //FirebaseCrash.log("Trying to call");
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918123848682"));
                        startActivity(intent);
                    } else {
                        Snackbar.make(view, "Grant permission to make call", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                    }
                } else {
                    Snackbar.make(view, "Insert SIM card to call Dhyana Mandira - Rajkumar", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private boolean checkCallPermission() {
        String callPermission = Manifest.permission.CALL_PHONE;
        int hasPermission = ContextCompat.checkSelfPermission(this, callPermission);
        String[] permissions = new String[]{callPermission};
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CALL_PHONE);
            return false;
        }
        return true;
    }

    public boolean isSimPresent(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);  //gets the current TelephonyManager
        return !(tm.getSimState() == TelephonyManager.SIM_STATE_ABSENT);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about_dmyk) {
            fragmentTransaction = fm.beginTransaction();
            AboutFragment f1 = new AboutFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_events) {

        } else if (id == R.id.nav_cost_involved) {
            fragmentTransaction = fm.beginTransaction();
            CostFragment f1 = new CostFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_experiences) {

        } else if (id == R.id.nav_mail) {

        } else if (id == R.id.nav_call) {

        } else if (id == R.id.nav_visit) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_facebook_like) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}