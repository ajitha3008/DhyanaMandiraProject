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

public class AstangaYogaFragment extends Fragment {
    String aboutAstangaYoga = "<html><body style=\"text-align:justify\"><font color=\"#ff9933\"><b>\"ASTANGA YOGA\" - a path towards \"ULTIMATE\"</b></font><br><br>Pathanjali Maharshi\'s Astanga Yoga Sutras (8 limbs) are simple and most effective guidelines to reach an \"Ultimate\" state of life. Yama, Niyama, Asana, Pranayama, Pratyahara, Dharana, Dhyana & Samadhi - the path that takes one towards ultimate.<br><br>These 8 sutras with more sub sutras help the practitioner for total personality development. The Physical, Mental, Emotional, Social, Spiritual wellbeing are the aims. The Yogic Life is much needed for Individual health and social harmony.<br><br><i><font color=\"#ff9933\">How this is being achieved here..?? see the next page on \"DHYANA MANDIRA\" - a \"PLATFORM\" to \"TRANSFORM\".</font></i></body></Html>";

    private WebView webView;

    String htmlText = " %s ";

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_cost, vg, false);
        webView = (WebView) view.findViewById(R.id.webView_cost);
        webView.loadData(String.format(htmlText, aboutAstangaYoga), "text/html", "utf-8");
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                AnimUtils.animate(view, getActivity());
                view.scrollTo(0, 0);
            }
        });
        return view;
    }
}
