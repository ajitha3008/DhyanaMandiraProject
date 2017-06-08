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

public class CostFragment extends Fragment {
    String registrationCost = "<html><body style=\"text-align:justify\">We believe YOGA is a field of service. Hence, we have not commercialized Yoga. Yoga aspirants can take life time membership by paying only Rs.100/-. There is NO monthly fees for providing training & venue for daily practice. You will be provided a continued guidance for life time.<br><br>New people can join during new batches. Register for new batches through telephone call, SMS, Whatsapp or Email. Just send your Full name, Whatsapp number(preferably) and Email ID to the contact details provided. We will inform you about the dates for next new batch.<br><br>We have enough place for Yoga practice. Any number of people can join. Inform and spread to everyone you know.</body></Html>";

    private WebView webView;

    String htmlText = " %s ";

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_cost, vg, false);
        webView = (WebView) view.findViewById(R.id.webView_cost);
        webView.loadData(String.format(htmlText, registrationCost), "text/html", "utf-8");
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                AnimUtils.animate(view, getActivity());
                view.scrollTo(0, 0);
            }
        });
        return view;
    }
}
