package com.braingalore.dhyanamandira.model;

/**
 * Created by s92 on 5/8/2017.
 */

public class GalleryObject {
    private String title, url;

    public GalleryObject() {
    }

    public GalleryObject(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
