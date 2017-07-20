package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.adapter.GalleryGridViewAdapter;
import com.google.firebase.crash.FirebaseCrash;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by s92 on 5/4/2017.
 */

public class GalleryFragment extends Fragment {

    GalleryGridViewAdapter galleryAdapter;

    GridView gridView;

    TextView googlePlusTextView;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_view_layout, vg, false);
        gridView = (GridView) view.findViewById(R.id.gallery_grid);
        googlePlusTextView = (TextView) view.findViewById(R.id.googlePlusTextView);
        googlePlusTextView.setText(getActivity().getString(R.string.marquee_text));
        googlePlusTextView.setPaintFlags(googlePlusTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        googlePlusTextView.setSelected(true);
        googlePlusTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://plus.google.com/104001892080880835190/posts")));
            }
        });
        ArrayList<String> filePaths = getFilePaths();
        try {
            if (!filePaths.isEmpty()) {
                galleryAdapter = new GalleryGridViewAdapter(getActivity(), R.layout.grid_item, filePaths, gridView);
                gridView.setAdapter(galleryAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private ArrayList<String> getFilePaths() {
        ArrayList<String> uris = new ArrayList<>();
        AssetManager assetManager = getActivity().getAssets();
        try {
            String[] files = assetManager.list("gallery_images");

            for (String strImageName : files) {
                String pathAssets = "gallery_images" + File.separator + strImageName;
                uris.add(pathAssets);

            }
        } catch (Exception e) {
            FirebaseCrash.report(new Exception("Exception while getting asset URIs" + e));
        }
        return uris;
    }
}
