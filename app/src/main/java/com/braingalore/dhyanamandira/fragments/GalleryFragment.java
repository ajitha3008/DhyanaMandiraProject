package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.braingalore.dhyanamandira.AsyncResult;
import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.adapter.GalleryAdapter;
import com.braingalore.dhyanamandira.model.GalleryObject;
import com.braingalore.dhyanamandira.spreadsheetreader.GalleryReader;
import com.braingalore.dhyanamandira.utils.DividerItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s92 on 5/4/2017.
 */

public class GalleryFragment extends Fragment {

    RecyclerView galleryItemList;

    GalleryAdapter galleryAdapter;

    List<GalleryObject> galleryObjectList;

    ProgressDialog pDialog;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_layout, vg, false);
        galleryItemList = (RecyclerView) view.findViewById(R.id.recycler_view);
        galleryItemList.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);
        pDialog.setMessage("Loading...");
        pDialog.show();
        new GalleryReader(new AsyncResult() {
            @Override
            public void onCommentsResult(JSONObject object) {

            }

            @Override
            public void onGalleryResult(JSONObject object) {
                galleryObjectList = prepareGallerydata(object);
                galleryAdapter = new GalleryAdapter(galleryObjectList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                galleryItemList.setLayoutManager(mLayoutManager);
                //commentsList.setItemAnimator(new DefaultItemAnimator());
                galleryItemList.setAdapter(galleryAdapter);
                if (pDialog != null && pDialog.isShowing()) {
                    pDialog.dismiss();
                }
                galleryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onEventsResult(JSONObject object) {

            }
        }).execute("");
        return view;
    }

    private List<GalleryObject> prepareGallerydata(JSONObject object) {
        galleryObjectList = new ArrayList<GalleryObject>();
        try {
            JSONArray rows = object.getJSONArray("rows");

            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");
                String desc = columns.getJSONObject(0).getString("v");
                String link = columns.getJSONObject(1).getString("v");
                if (!TextUtils.isEmpty(desc) && !TextUtils.isEmpty(link) && !link.equals("link"))
                    galleryObjectList.add(new GalleryObject(desc, link));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return galleryObjectList;
    }
}
