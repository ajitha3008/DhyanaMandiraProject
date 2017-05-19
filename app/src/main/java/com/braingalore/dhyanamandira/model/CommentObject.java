package com.braingalore.dhyanamandira.model;

/**
 * Created by s92 on 5/8/2017.
 */

public class CommentObject {
    private String name, comment;

    private int ratingCount;

    public CommentObject() {
    }

    public CommentObject(int ratingCount, String name, String comment) {
        this.ratingCount = ratingCount;
        this.name = name;
        this.comment = comment;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int count) {
        this.ratingCount = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
