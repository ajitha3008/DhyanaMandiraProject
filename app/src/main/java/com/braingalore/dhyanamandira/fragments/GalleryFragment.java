package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.adapter.GalleryGridViewAdapter;
import com.braingalore.dhyanamandira.model.GalleryObject;
import com.google.firebase.crash.FirebaseCrash;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by s92 on 5/4/2017.
 */

public class GalleryFragment extends Fragment {

    RecyclerView galleryItemList;

    GalleryGridViewAdapter galleryAdapter;

    List<GalleryObject> galleryObjectList;

    ProgressDialog pDialog;

    GridView gridView;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_view_layout, vg, false);
        gridView = (GridView) view.findViewById(R.id.gallery_grid);

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
