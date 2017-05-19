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
import com.braingalore.dhyanamandira.adapter.CommentsAdapter;
import com.braingalore.dhyanamandira.model.CommentObject;
import com.braingalore.dhyanamandira.spreadsheetreader.CommentsReader;
import com.braingalore.dhyanamandira.utils.DividerItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s92 on 5/4/2017.
 */

public class CommentsFragment extends Fragment {

    RecyclerView commentsList;

    CommentsAdapter commentsAdapter;

    List<CommentObject> commentObjectList;

    ProgressDialog pDialog;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_layout, vg, false);
        commentsList = (RecyclerView) view.findViewById(R.id.recycler_view);
        commentsList.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);
        pDialog.setMessage("Loading...");
        pDialog.show();
        new CommentsReader(new AsyncResult() {
            @Override
            public void onCommentsResult(JSONObject object) {
                commentObjectList = prepareCommentData(object);
                commentsAdapter = new CommentsAdapter(commentObjectList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                commentsList.setLayoutManager(mLayoutManager);
                //commentsList.setItemAnimator(new DefaultItemAnimator());
                commentsList.setAdapter(commentsAdapter);
                if (pDialog != null && pDialog.isShowing()) {
                    pDialog.dismiss();
                }
                commentsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onGalleryResult(JSONObject object) {

            }

            @Override
            public void onEventsResult(JSONObject object) {

            }
        }).execute("");
        return view;
    }

    private List<CommentObject> prepareCommentData(JSONObject object) {
        commentObjectList = new ArrayList<CommentObject>();
        /*commentObjectList.add(new CommentObject(5, "Ajitha Yasmin","Excellent place to practise Yoga. Selfless master inspires lot of lives by his service and effort... The experience you gain here will definitely change your habits. Totally worth the time. Please join without any second thoughts.\n"));
        commentObjectList.add(new CommentObject(5, "Sushil Shah ","Amazing team, amazing environment, getting yoga lessons in front of Adiyogi it cant get better than this.\n"));
        commentObjectList.add(new CommentObject(5, "Manoj Km","Perfect Place for doing Yoga early morning @ Siva temple .. Excellent Guru... Nice Group, Good environment...\n"));
        commentObjectList.add(new CommentObject(5, "Chirag Ojha","A free service to the public provide by dedicated people bringing changes that are so positive and refreshing. Yoga is the way of life.. !!\n"));
        commentObjectList.add(new CommentObject(5, "P Venkat Prasad","It is one of My personal fitness mantra\n" +
                "My weight-loss formula\n" +
                "My mind soother\n" +
                "My tool for better communication\n" +
                "My creativity machine\n" +
                "My doubt repeller\n" +
                "My time planner\n" +
                "all are there here.\n"));
        commentObjectList.add(new CommentObject(5, "Ravikiran Allu","It's the best place to make Yoga as your habit. Here you learn many new concepts about nature.\n"));
        commentObjectList.add(new CommentObject(5, "Harish Raghuramaiah ","Yoga is a pure science of Human Body , It helps to keep body in very good health.\n" +
                "It helps to remove impurities form body. I Express Deep Gratitude to the Service Rendered by the Someshwara Temple Centre to all the people(ALL THE TEACHERS IN PARTICULAR IN THIS TRADITION) responsible for this. Thank you ALL SO MUCH.\n"));
        commentObjectList.add(new CommentObject(5, "Aparna Ogoti","Best place to start yoga for beginners. Only 100 rupees for registration, there is no monthly fee. After completion of your batch if you want continue you can come daily. Yoga is good for physical and mental health also.\n"));
        commentObjectList.add(new CommentObject(5, "Sukanya Patnaik","Daily yoga class for free. After joining the class we will come to know about physical, mental health. We can participate in so many social activities. A very good place where we can start a healthy day.\n"));
        commentObjectList.add(new CommentObject(4, "praveen mdw","Yoga Practice held every day by professionals without any fee.\n" +
                "one can see practitioners performing yoga since years. Initially basic training will be provided then to practice yoga along with Senior members  ,fun to learn and perform yoga.\n"));
        //commentObjectList.add(new CommentObject(, "",""));*/
        try {
            JSONArray rows = object.getJSONArray("rows");

            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");

                int starCount = columns.getJSONObject(0).getInt("v");
                String name = columns.getJSONObject(1).getString("v");
                String comment = columns.getJSONObject(2).getString("v");
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(comment) && !name.equals("name"))
                    commentObjectList.add(new CommentObject(starCount, name, comment));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return commentObjectList;
    }
}
