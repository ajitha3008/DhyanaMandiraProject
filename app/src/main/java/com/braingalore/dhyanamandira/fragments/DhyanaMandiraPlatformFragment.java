package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
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

public class DhyanaMandiraPlatformFragment extends Fragment {
    String platformToTransform = "<html><body style=\"text-align:justify\">DHYANA MANDIRA - A PLATFORM TO TRANSFORM<br><br>At Dhyana Mandira Yoga Kendra, The Astanga Yoga Sutras are being delivered to Yoga aspirants through various Yogic activities, Satsanga, Special events, Nature & Spiritual spots visits, etc.<br><br>A brief Syllabus during basic course period of 5 weeks:<br><ul><li>Briefings on Yoga Shastra</li><li>Mind control exercises</li><li>Breathing exercises</li><li>Body joints exercises (can be utilized as workplace exercises)</li><li>Yogasanas (more than 100) practice</li><li>Surya Namaskara</li><li>Pranayama sessions</li><li>Yoga Shibhiras (Camps at special places)</li><li>Special sessions on personality development (Stress management, Self-confidence, Communication skills, Art of Public speech, Simplicity etc.)</li><li>Fine tuning Asanas practice through various techniques</li><li>Mantras</li></ul><br>Refer next page for the Abhyasas (activities) for daily practice.</body></Html>";

    private WebView webView;

    String htmlText = " %s ";

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_cost, vg, false);
        webView = (WebView) view.findViewById(R.id.webView_cost);
        webView.loadData(String.format(htmlText, platformToTransform), "text/html", "utf-8");
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                AnimUtils.animate(view, getActivity());
                view.scrollTo(0, 0);
            }
        });
        return view;
    }
}
