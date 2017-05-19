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
import android.widget.Toast;

import com.braingalore.dhyanamandira.AsyncResult;
import com.braingalore.dhyanamandira.HomeActivity;
import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.adapter.EventsAdapter;
import com.braingalore.dhyanamandira.model.EventsObject;
import com.braingalore.dhyanamandira.spreadsheetreader.EventsReader;
import com.braingalore.dhyanamandira.utils.DividerItemDecoration;
import com.google.firebase.crash.FirebaseCrash;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s92 on 5/4/2017.
 */

public class EventsFragment extends Fragment {

    RecyclerView eventRecyclerView;

    EventsAdapter eventsAdapter;

    List<EventsObject> eventsObjectList;

    ProgressDialog pDialog;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_layout, vg, false);
        eventRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        eventRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        if (((HomeActivity) getActivity()).isNetworkAvailable()) {
            pDialog = new ProgressDialog(getActivity());
            pDialog.setCancelable(false);
            pDialog.setMessage("Loading...");
            pDialog.show();
            new EventsReader(new AsyncResult() {
                @Override
                public void onCommentsResult(JSONObject object) {

                }

                @Override
                public void onGalleryResult(JSONObject object) {

                }

                @Override
                public void onEventsResult(JSONObject object) {
                    eventsObjectList = prepareEventData(object);
                    eventsAdapter = new EventsAdapter(eventsObjectList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                    eventRecyclerView.setLayoutManager(mLayoutManager);
                    //eventRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    eventRecyclerView.setAdapter(eventsAdapter);
                    if (pDialog != null && pDialog.isShowing()) {
                        pDialog.dismiss();
                    }
                    eventsAdapter.notifyDataSetChanged();
                }
            }).execute("");
        } else {
            Toast.makeText(getActivity(), "Please connect to internet to proceed...", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    private List<EventsObject> prepareEventData(JSONObject object) {
        eventsObjectList = new ArrayList<EventsObject>();
        if (object != null) {
            try {
                JSONArray rows = object.getJSONArray("rows");

                for (int r = 0; r < rows.length(); ++r) {
                    JSONObject row = rows.getJSONObject(r);
                    JSONArray columns = row.getJSONArray("c");
                    String name = columns.getJSONObject(0).getString("v");
                    String location = columns.getJSONObject(1).getString("v");
                    String date = columns.getJSONObject(2).getString("v");
                    String description = columns.getJSONObject(3).getString("v");
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(location) && !TextUtils.isEmpty(date) && !TextUtils.isEmpty(description) && !name.equals("name"))
                        eventsObjectList.add(new EventsObject(name, location, date, description));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            FirebaseCrash.report(new Exception("Events JSON object null"));
        }
        //eventsObjectList.add(new EventsObject("Event Name : New Batch","Event Location : Someshwara Temple","Event Date : May 16, 2017","Event Desc : New batch of Yoga starts!"));
        return eventsObjectList;
    }
}
