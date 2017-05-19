package com.braingalore.dhyanamandira.utils;

import android.content.Context;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareButton;

/**
 * Created by s92 on 5/5/2017.
 */

public class AnimUtils {
    public static void animate(WebView view, Context context) {
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(context,
                android.R.anim.slide_in_left);
        view.startAnimation(anim);
    }

    public static void animate(TextView view, Context context) {
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(context,
                android.R.anim.slide_in_left);
        view.startAnimation(anim);
    }

    public static void animate(LikeView view, Context context) {
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(context,
                android.R.anim.slide_in_left);
        view.startAnimation(anim);
    }

    public static void animate(ShareButton view, Context context) {
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(context,
                android.R.anim.slide_in_left);
        view.startAnimation(anim);
    }

    public static void animate(LinearLayout view, Context context) {
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(context,
                android.R.anim.slide_in_left);
        view.startAnimation(anim);
    }
}
