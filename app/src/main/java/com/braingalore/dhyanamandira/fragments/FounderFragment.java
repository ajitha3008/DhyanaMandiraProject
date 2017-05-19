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

    String aboutSir = "<html><body style=\"text-align:justify\"><i>Rajkumar Gour is the Mukhya Shikshaka of the Dhyana Mandira Yoga Kendra center. He is a selfless person preaching YOGA at his own interest. He is a working professional. During mornings he preaches YOGA for the wellness of human beings.</i></body></Html>";

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