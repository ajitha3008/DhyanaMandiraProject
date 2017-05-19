package com.braingalore.dhyanamandira;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import com.braingalore.dhyanamandira.fragments.VisitFragment;
import com.braingalore.dhyanamandira.utils.CallingUtils;
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
                if (CallingUtils.isSimPresent(HomeActivity.this)) {
                    CallingUtils.dialIntent(HomeActivity.this, "+918123848682", view);
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
        }
        if (id == R.id.nav_about_founder) {
            fragmentTransaction = fm.beginTransaction();
            FounderFragment f1 = new FounderFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_events) {
            fragmentTransaction = fm.beginTransaction();
            EventsFragment f1 = new EventsFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_cost_involved) {
            fragmentTransaction = fm.beginTransaction();
            CostFragment f1 = new CostFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_gallery) {
            fragmentTransaction = fm.beginTransaction();
            GalleryFragment f1 = new GalleryFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_experiences) {
            fragmentTransaction = fm.beginTransaction();
            CommentsFragment f1 = new CommentsFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_mail) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.fromParts("mailto", "rajayogamadiwala@gmail.com", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, "DhyanaMandira :: Contact Us");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else if (id == R.id.nav_call) {
            fragmentTransaction = fm.beginTransaction();
            CallOptionsFragment f1 = new CallOptionsFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_visit) {
            fragmentTransaction = fm.beginTransaction();
            VisitFragment f1 = new VisitFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commit();
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
            fragmentTransaction.commit();
        } else if (id == R.id.nav_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String shareSubText = "Dhyana Mandira Yoga Kendra";
            String shareBodyText = "https://play.google.com/store/apps/details?id=com.braingalore.dhyanamandira&hl=en";
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubText);
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(shareIntent, "Share With"));
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
}