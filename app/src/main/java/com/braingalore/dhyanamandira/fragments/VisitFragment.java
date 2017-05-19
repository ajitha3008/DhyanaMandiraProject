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
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.crash.FirebaseCrash;

/**
 * Created by s92 on 5/4/2017.
 */

public class VisitFragment extends Fragment implements OnMapReadyCallback {

    String postalAddress = "<html><body style=\"text-align:justify\">Click on the marker above to get directions<i><br><br><b>PostalAddress:</b><br>Rajkumar G<br>Mukhya Shikshaka<br>Dhyana Mandira Yoga Kendra<br>Shri Someshwara(Shiva) Temple,<br>Madiwala,<br>BTM 1st Stage,<br>Bangalore,<br>560068</i></body></Html>";

    private WebView webView;

    String htmlText = " %s ";

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.visit_fragment, vg, false);

        try {
        /*mMapView = (MapView)view.findViewById(R.id.mapview);
        mMapView.getMapAsync(this);*/
            MapFragment mapFragment = (MapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map_fragment);
            if (mapFragment != null) {
                mapFragment.getMapAsync(this);
            }
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("Error in maps " + e));
        }

        webView = (WebView) view.findViewById(R.id.postal_webview);
        webView.loadData(String.format(htmlText, postalAddress), "text/html", "utf-8");
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                AnimUtils.animate(view, getActivity());
                view.scrollTo(0, 0);
            }
        });
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        LatLng dhyanaMandir = new LatLng(12.918235, 77.618393);
        googleMap.addMarker(new MarkerOptions().position(dhyanaMandir).title("Dhyana Mandir"));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(dhyanaMandir, 10);
        googleMap.animateCamera(cameraUpdate);
    }
}
