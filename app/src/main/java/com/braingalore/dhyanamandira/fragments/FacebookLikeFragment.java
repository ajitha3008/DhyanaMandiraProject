package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.braingalore.dhyanamandira.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareButton;


/**
 * Created by s92 on 5/4/2017.
 */

public class FacebookLikeFragment extends Fragment {

    String content = "<html><body style=\"text-align:justify\"><i>Share and like us in facebook.</i></body></Html>";

    private WebView contentView;
    private LikeView likeview;
    private ShareButton shareButton;
    CallbackManager callbackManager;
    String htmlText = " %s ";

    private void initCallbackManager() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        initCallbackManager();
        View view = inflater.inflate(R.layout.facebook_like, vg, false);
        contentView = (WebView) view.findViewById(R.id.webview_fblike);
        contentView.loadData(String.format(htmlText, content), "text/html", "utf-8");
        contentView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                view.scrollTo(0, 0);
            }
        });
        likeview = (LikeView)view.findViewById(R.id.like_view);
        likeview.setObjectIdAndType("https://www.facebook.com/DhyanaMandiraSomeshwaraTemple", LikeView.ObjectType.PAGE);
        likeview.setFragment(this);
        likeview.setLikeViewStyle(LikeView.Style.BOX_COUNT);

        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://www.facebook.com/DhyanaMandiraSomeshwaraTemple"))
                .build();

        shareButton = (ShareButton)view.findViewById(R.id.share_view);
        shareButton.setShareContent(linkContent);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Handle Facebook Login Result
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}