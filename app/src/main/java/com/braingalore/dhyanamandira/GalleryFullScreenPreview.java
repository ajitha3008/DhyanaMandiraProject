package com.braingalore.dhyanamandira;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * Created by S92 on 5/20/2017.
 */

public class GalleryFullScreenPreview extends Activity {
    Button close;
    ImageView imageView;
    ImageLoader imageLoader;
    DisplayImageOptions options;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fullscreen_image);
        close = (Button) findViewById(R.id.btnClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        String title = getIntent().getStringExtra("title");
        TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText(title);
        imageLoader = ImageLoader.getInstance();
        this.imageLoader.init(new ImageLoaderConfiguration.Builder(this).defaultDisplayImageOptions(options).build());
        options = new DisplayImageOptions.Builder()
                .cacheInMemory()
                .displayer(new FadeInBitmapDisplayer(500)) //fade in images
                .resetViewBeforeLoading()
                .build();
        String uriString = getIntent().getStringExtra("itemuri");
        imageView = (ImageView) findViewById(R.id.imgDisplay);
        String tempStr = "assets://" + uriString;
        lazyLoading(imageLoader, tempStr, imageView, options);
    }

    public static void lazyLoading(ImageLoader imageLoader, String tempStr, ImageView imageView, DisplayImageOptions options) {
        imageLoader.displayImage(tempStr, imageView, options,
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                    }
                }, new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String imageUri, View view, int current, int total) {
                    }
                });
    }
}
