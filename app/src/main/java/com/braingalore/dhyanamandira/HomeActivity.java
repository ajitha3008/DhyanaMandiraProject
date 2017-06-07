package com.braingalore.dhyanamandira;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.braingalore.dhyanamandira.fragments.AboutFragment;
import com.braingalore.dhyanamandira.fragments.CallOptionsFragment;
import com.braingalore.dhyanamandira.fragments.CommentsFragment;
import com.braingalore.dhyanamandira.fragments.CostFragment;
import com.braingalore.dhyanamandira.fragments.EventsFragment;
import com.braingalore.dhyanamandira.fragments.FacebookLikeFragment;
import com.braingalore.dhyanamandira.fragments.FounderFragment;
import com.braingalore.dhyanamandira.fragments.GalleryFragment;
import com.braingalore.dhyanamandira.fragments.MantrasFragment;
import com.braingalore.dhyanamandira.fragments.VisitFragment;
import com.braingalore.dhyanamandira.utils.CallingUtils;
import com.google.firebase.crash.FirebaseCrash;
/*import com.facebook.share.widget.LikeView;
import com.sun.mail.smtp.SMTPTransport;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //for testing
        //FirebaseCrash.log("Activity created");
        //FirebaseCrash.logcat(Log.ERROR, "ajitha", "No error");
        //FirebaseCrash.report(new Exception("My first Android non-fatal error"));

        fm = getFragmentManager();
        try {
            fragmentTransaction = fm.beginTransaction();
            AboutFragment f1 = new AboutFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("Error while committing initial fragment " + e));
            finish();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CallingUtils.isSimPresent(HomeActivity.this)) {
                    CallingUtils.dialIntent(HomeActivity.this, "+917349782713", view);
                } else {
                    Snackbar.make(view, "Insert SIM card to call Rajkumar", Snackbar.LENGTH_LONG)
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

    @Override
    protected void onResume() {
        super.onResume();
        if (Constants.FIREBASE_ACTION.equals(getIntent().getAction())) {
            String title = getResources().getString(R.string.app_name);
            String body = getIntent().getStringExtra(Constants.FIREBASE_BODY);
            if (!TextUtils.isEmpty(body)) {
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(this);
                builder.setTitle(title);
                builder.setMessage(body)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                        .setCancelable(false)
                        .show();
            }
        }
        getIntent().setAction("");
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
        try {
            if (id == R.id.nav_about_dmyk) {
                fragmentTransaction = fm.beginTransaction();
                AboutFragment f1 = new AboutFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Dhyana Mandira Yoga Kendra");
            }
            if (id == R.id.nav_about_founder) {
                fragmentTransaction = fm.beginTransaction();
                FounderFragment f1 = new FounderFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Founder");
            } else if (id == R.id.nav_events) {
                fragmentTransaction = fm.beginTransaction();
                EventsFragment f1 = new EventsFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Events");
            } else if (id == R.id.nav_cost_involved) {
                fragmentTransaction = fm.beginTransaction();
                CostFragment f1 = new CostFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Registration Formality");
            } else if (id == R.id.nav_gallery) {
                fragmentTransaction = fm.beginTransaction();
                GalleryFragment f1 = new GalleryFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Gallery");
            } else if (id == R.id.nav_experiences) {
                fragmentTransaction = fm.beginTransaction();
                CommentsFragment f1 = new CommentsFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Comments");
            } else if (id == R.id.nav_mail) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.fromParts("mailto", "rajkumargour10@gmail.com", null));
                intent.putExtra(Intent.EXTRA_CC, new String[] { "rajayogamadiwala@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "DhyanaMandira :: Contact Us");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            } else if (id == R.id.nav_call) {
                fragmentTransaction = fm.beginTransaction();
                CallOptionsFragment f1 = new CallOptionsFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Call");
            } else if (id == R.id.nav_visit) {
                fragmentTransaction = fm.beginTransaction();
                VisitFragment f1 = new VisitFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Visit");
            } else if (false/*id == R.id.nav_feedback*/) {
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.feedback_fragment);
                dialog.setTitle("Provide Feedback");
                final EditText mailID = (EditText) dialog.findViewById(R.id.feedback_mail_edittext);
                final EditText name = (EditText) dialog.findViewById(R.id.feedback_name_edittext);
                final EditText message = (EditText) dialog.findViewById(R.id.feedback_message_edittext);
                Button send = (Button) dialog.findViewById(R.id.feedback_send);
                Button cancel = (Button) dialog.findViewById(R.id.feedback_cancel);
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendMail(mailID.getText().toString(), name.getText().toString(), message.getText().toString());
                        dialog.dismiss();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                //dialog.show();
            } else if (id == R.id.nav_facebook_like) {
                fragmentTransaction = fm.beginTransaction();
                FacebookLikeFragment f1 = new FacebookLikeFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Like & Share");
            } else if (id == R.id.nav_share) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareSubText = "Dhyana Mandira Yoga Kendra";
                String shareBodyText = "https://play.google.com/store/apps/details?id=com.braingalore.dhyanamandira&hl=en";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubText);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(shareIntent, "Share With"));
            } else if(id==R.id.mantras) {
                fragmentTransaction = fm.beginTransaction();
                MantrasFragment f1 = new MantrasFragment();
                fragmentTransaction.replace(R.id.fragment_container, f1);
                fragmentTransaction.commitAllowingStateLoss();
                toolbar.setTitle("Mantras");
            }
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("Exception while committing consecutive fragments " + e));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //LikeView.handleOnActivityResult(this, requestCode, resultCode, data);
    }

    private void sendMail(final String mail, final String name, final String message) {
       /* new Thread(){
            public void run() {
        Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress("thoughtgalore@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("aji.b2w@gmail.com", false));
            msg.setSubject("Dhyana Mandira :: Feedback " + System.currentTimeMillis());
            msg.setText("MAIL:"+mail+"\nNAME:"+name+"\nMESSAGE:"+message);
            msg.setHeader("X-Mailer", "Dhyana Mandira");
            msg.setSentDate(new Date());
            SMTPTransport t =
                    (SMTPTransport) session.getTransport("smtps");
            t.connect("smtp.gmail.com", "thoughtgalore@gmail.com", "#30ija11an");
            t.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Response: " + t.getLastServerResponse());
            t.close();
        }catch (AddressException e) {
            e.printStackTrace();
        } catch (SendFailedException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
            }
        }.start();*/
    }

    public boolean isNetworkAvailable() {
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("Error while trying to check network availability " + e));
            return false;
        }
    }
}