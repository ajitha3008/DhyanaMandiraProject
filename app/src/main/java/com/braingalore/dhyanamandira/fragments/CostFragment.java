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
    String registrationCost = "<html><body style=\"text-align:justify\">The secondary level of basic need for any human being is Health & Education. The ancient Indian value system provided these free-of-cost to everyone in the society. These were considered as fields of selfless service. \"Dhyana Mandira Yoga Kendra\" acknowledges these values and hence did not commercialize Yoga. Unlike other commercial yoga centers, there is NO monthly fees for providing training and venue for daily practise along with continued guidance for lifetime. Yoga aspirants can enroll for a Life-Time membership for just Rs.100/-</body></Html>";

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
