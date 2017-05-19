package com.braingalore.dhyanamandira.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.model.GalleryObject;

import java.util.List;

/**
 * Created by s92 on 5/8/2017.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {
    private List<GalleryObject> galleryObjectList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleText, url;

        public MyViewHolder(View view) {
            super(view);
            titleText = (TextView) view.findViewById(R.id.gallery_title);
            url = (TextView) view.findViewById(R.id.gallery_url);
        }
    }

    public GalleryAdapter(List<GalleryObject> items) {
        galleryObjectList = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_row_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GalleryObject galleryObject = galleryObjectList.get(position);
        holder.titleText.setText(galleryObject.getTitle());
        holder.url.setText(galleryObject.getUrl());
    }

    @Override
    public int getItemCount() {
        return galleryObjectList.size();
    }
}
