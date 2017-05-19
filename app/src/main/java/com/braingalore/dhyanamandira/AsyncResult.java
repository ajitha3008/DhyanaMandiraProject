package com.braingalore.dhyanamandira;


import org.json.JSONObject;

/**
 * Created by S92 on 5/19/2017.
 */
public interface AsyncResult {
    void onCommentsResult(JSONObject object);

    void onGalleryResult(JSONObject object);

    void onEventsResult(JSONObject object);
}
