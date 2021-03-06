package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;
import android.widget.TextView;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.utils.AnimUtils;

/**
 * Created by s92 on 5/4/2017.
 */

public class AboutFragment extends Fragment {

    String about = "<html><body style=\"text-align:justify\">\"Yoga Mandira\" is a center for Yoga & Spiritual activities. It was started in the year 2009. Aimed at well being of individuals and social harmony through yoga. The traditional and ancient method of Astanga Yoga is the kind of yoga being followed here. We provide FREE yoga training to anybody who joins as a beginner. We conduct daily yogasana practice sessions and other associated activities at early morning hours.<br><br>New batches will be initiated every 5 weeks. New people(yoga aspirants) can join new batch by taking life time membership with just Rs100/-.  The beginners will be trained with all basic exercises(body, breath & mind). More than 100 Asanas, Surya Namaskara and Pranayama etc., will be taught. Also, with various training methods, the practitioners will be fine tuned and made to perfect practice of asanas. After undergoing the basic training, people can continue regular practice at \"Yoga Mandira\" premises as long as they wish to. No monthly fees for life time.<br><br>Apart from daily asana sessions, there will be many special events & programs for total personality development. Satsanga, Bauddhik sessions, lectures, social service activities, yoga awareness activities etc., will be conducted.<br><br>\"Yoga Mandira\" is a divine hall at Sri Someshwara (Shiva) Temple premises in Madiwala, BTM 1st Stage, Bangalore-560 068.<br><br><p align=\"center\">!!!......HARI AUM......!!!</p></body></Html>";

    private WebView aboutView;

    String htmlText = " %s ";

    Context context;

    View fullView;

    TextView headingView;

    ScrollView scrollView;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        fullView = inflater.inflate(R.layout.content_about, vg, false);
        scrollView = (ScrollView)fullView.findViewById(R.id.scroll_view);
        context = getActivity();
        aboutView = (WebView) fullView.findViewById(R.id.webView_about);
        headingView = (TextView) fullView.findViewById(R.id.dhyana_text_view);
        aboutView.loadData(String.format(htmlText, about), "text/html", "utf-8");
        return fullView;
    }
}