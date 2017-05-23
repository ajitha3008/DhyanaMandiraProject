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

public class FounderFragment extends Fragment {

    String aboutSir = "<html><body style=\"text-align:justify\"><i>\"Shri Rajkumar Gour\" is Mukhya Yoga Shikshaka and Chief Administrator at \"Dhyana Mandira\". He chose Yoga as a path of service in the year 2009 and has provided yoga coaching to more than 5500 people as of now. He is a Yoga Pracharak and Yoga Shikshaka. His service in the yoga field through this Dhyana Mandira is great inspiration and motivation for the people who gets associated with this yoga kendra. Many lives have changed with his way of yoga teachings and thus his service is a noticeable contribution to the society. His selfless and constant efforts have made \"Dhyana Mandira\" - as an epicenter of Yoga in this region of Bangalore.</i></body></Html>";

    private WebView aboutSirView;

    String htmlText = " %s ";

    Context context;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_founder, vg, false);
        context = getActivity();
        aboutSirView = (WebView) view.findViewById(R.id.webView_about_sir);
        aboutSirView.loadData(String.format(htmlText, aboutSir), "text/html", "utf-8");
        aboutSirView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                AnimUtils.animate(view, context);
                view.scrollTo(0, 0);
            }
        });
        return view;
    }
}