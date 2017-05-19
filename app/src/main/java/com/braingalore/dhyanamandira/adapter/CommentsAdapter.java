package com.braingalore.dhyanamandira.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.model.CommentObject;

import java.util.List;

/**
 * Created by s92 on 5/8/2017.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {
    private List<CommentObject> commentList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, comment;
        public RatingBar ratingBar;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.commentator);
            comment = (TextView) view.findViewById(R.id.actual_comment);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        }
    }

    public CommentsAdapter(List<CommentObject> comments) {
        commentList = comments;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comments_row_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CommentObject commentObject = commentList.get(position);
        holder.name.setText(commentObject.getName());
        holder.comment.setText(commentObject.getComment());
        holder.ratingBar.setRating(commentObject.getRatingCount());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
