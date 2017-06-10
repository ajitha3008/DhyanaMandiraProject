package com.braingalore.dhyanamandira.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.model.AbhyasasObject;

import java.util.List;

/**
 * Created by s92 on 5/8/2017.
 */

public class AbhyasasAdapter extends RecyclerView.Adapter<AbhyasasAdapter.MyViewHolder> {
    private List<AbhyasasObject> abhyasasObjects;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView abhyasaTitleView, abhyasaTextView;

        public MyViewHolder(View view) {
            super(view);
            abhyasaTextView = (TextView) view.findViewById(R.id.abhyasa_textView);
            abhyasaTitleView = (TextView) view.findViewById(R.id.abhyasa_titleView);
        }
    }

    public AbhyasasAdapter(List<AbhyasasObject> abhyasasObjectList) {
        this.abhyasasObjects = abhyasasObjectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.abhyasa_row_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AbhyasasObject abhyasaSingleObject = abhyasasObjects.get(position);
        holder.abhyasaTitleView.setText(abhyasaSingleObject.getName());
        holder.abhyasaTextView.setText(abhyasaSingleObject.getAbhyasaItems());
    }

    @Override
    public int getItemCount() {
        return abhyasasObjects.size();
    }
}
