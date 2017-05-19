package com.braingalore.dhyanamandira.spreadsheetreader;

/**
 * Created by S92 on 5/19/2017.
 */

import android.os.AsyncTask;
import android.text.TextUtils;

import com.braingalore.dhyanamandira.AsyncResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GalleryReader extends AsyncTask<String, Void, String> {
    AsyncResult callback;

    public GalleryReader(AsyncResult callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(String... urls) {
        // params comes from the execute() call: params[0] is the url.
        try {
            return downloadUrl("https://spreadsheets.google.com/tq?key=12un8cfDiu-XHnuYKoASzPfBmR1vKzBRCJ77xu5nww1g");
        } catch (IOException e) {
            return "Unable to download the requested page.";
        }
    }

    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(String result) {
        // remove the unnecessary parts from the response and construct a JSON
        if (!TextUtils.isEmpty(result)) {
            int start = result.indexOf("{", result.indexOf("{") + 1);
            int end = result.lastIndexOf("}");
            String jsonResponse = result.substring(start, end);
            try {
                JSONObject table = new JSONObject(jsonResponse);
                callback.onGalleryResult(table);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            callback.onGalleryResult(null);
        }
    }

    private String downloadUrl(String urlString) throws IOException {
        InputStream is = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int responseCode = conn.getResponseCode();
            is = conn.getInputStream();
            String contentAsString = convertStreamToString(is);
            return contentAsString;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
