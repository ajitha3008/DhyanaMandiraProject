package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.braingalore.dhyanamandira.R;

/**
 * Created by s92 on 5/4/2017.
 */

public class AboutFragment extends Fragment {
    String about = "<html><body style=\"text-align:justify\"><i>\"Dhyana Mandira\" Yoga Kendra is a yoga school to educate people on yogic exercises FREE OF COST. This school is based primarily on Ashtanga Vinyasa style. In the modern world today, many healthstyle issues are introduced because of the way people prefer to live. \"Dhyana Mandira\" addresses your concerns and teaches you on basic yogic exercises involving several asanas, pranayamas etc., The yoga practises are preached in the premises of Someshwara temple located in BTM layout, Bangalore. In the divine premises, \"Dhyana Mandira\" encourages people to live a healthy and stress-free life. In order to reach wider audience, the founders promote the service free of cost.<br><br>In the journey of yoga practise, there are many optional yogic trips and outings. It is recommended to take these trips and be yourself present in the outings to inculcate the value of self-discipline. Participants are NOT expected to be on leave unless on emergency cases.<br><br>New batches will begin once in every 40 days and the information will be updated via banners/facebook and other social medias.</i></body></Html>";
    private WebView webView;

    String htmlText = " %s ";

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.content_about, vg, false);
        webView = (WebView)view.findViewById(R.id.webView_about);
        webView.loadData(String.format(htmlText, about), "text/html", "utf-8");
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                view.scrollTo(0,0);
            }
        });
        return view;
    }


}
