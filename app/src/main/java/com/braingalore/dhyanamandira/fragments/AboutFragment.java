package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.utils.AnimUtils;

/**
 * Created by s92 on 5/4/2017.
 */

public class AboutFragment extends Fragment {

    String about = "<html><body style=\"text-align:justify\">\"Dhyana Mandira Yoga Kendra\" is a center for Yoga & Spiritual activities. It was started in the year 2009. Aimed at well being of individuals and social harmony through yoga. The traditional and ancient method of Astanga Yoga is the kind of yoga being followed here. We provide FREE yoga training to anybody who joins as a beginner. We conduct daily yogasana practice sessions and other associated activities at early morning hours.<br><br>New batches will be initiated every 5 weeks. New people(yoga aspirants) can join new batch by taking life time membership with just Rs100/-.  The beginners will be trained with all basic exercises(body, breath & mind). More than 100 Asanas, Surya Namaskara and Pranayama etc., will be taught. Also, with various training methods, the practitioners will be fine tuned and made to perfect practice of asanas. After undergoing the basic training, people can continue regular practice at \"Dhyana Mandira\" premises as long as they wish to. No monthly fees for life time.<br><br>Apart from daily asana sessions, there will be many special events & programs for total personality development. Satsanga, Bauddhik sessions, lectures, social service activities, yoga awareness activities etc., will be conducted.<br><br>\"Dhyana Mandira\" is a divine hall at Sri Someshwara (Shiva) Temple premises in Madiwala, BTM 1st Stage, Bengaluru-560 068.<br><br><p align=\"center\">!!!......HARI AUM......!!!</p></body></Html>";

    private WebView aboutView;

    String htmlText = " %s ";

    Context context;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_about, vg, false);
        context = getActivity();
        aboutView = (WebView) view.findViewById(R.id.webView_about);
        aboutView.loadData(String.format(htmlText, about), "text/html", "utf-8");
        aboutView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                AnimUtils.animate(view, context);
                view.scrollTo(0, 0);
            }
        });
        return view;
    }
}