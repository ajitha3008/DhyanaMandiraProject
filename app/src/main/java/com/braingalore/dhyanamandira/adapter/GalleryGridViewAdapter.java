package com.braingalore.dhyanamandira.adapter;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.braingalore.dhyanamandira.GalleryFullScreenPreview;
import com.braingalore.dhyanamandira.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by s92 on 5/8/2017.
 */

public class GalleryGridViewAdapter extends BaseAdapter {
    Context context;
    int layoutResourceId;
    private ArrayList<String> griRowItems;
    LayoutInflater vi;
    ImageLoader imageLoader;
    String[] imageUrls;
    ArrayList<String> imagePath;
    DisplayImageOptions options;
    ViewHolder holder = null;

    public GalleryGridViewAdapter(Context context,
                                  int layoutResourceId, ArrayList<String> uris, GridView gridView) {
        this.context = context;
        this.griRowItems = uris;
        this.layoutResourceId = layoutResourceId;
        vi = (LayoutInflater) context
                .getSystemService(Service.LAYOUT_INFLATER_SERVICE);

        imageLoader = ImageLoader.getInstance();

        options = new DisplayImageOptions.Builder()
                .cacheInMemory()
                .displayer(new FadeInBitmapDisplayer(500)) //fade in images
                .resetViewBeforeLoading()
                .build();

        this.imageLoader.init(new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(options).build());
        boolean pauseOnScroll = false; // or true
        boolean pauseOnFling = true; // or false
        PauseOnScrollListener listener = new PauseOnScrollListener(imageLoader, pauseOnScroll, pauseOnFling);
        gridView.setOnScrollListener(listener);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = vi.inflate(R.layout.grid_item, parent,
                    false);
            holder = new ViewHolder();
        }

        holder.imageView = (ImageView) convertView.findViewById(R.id.img);
        holder.caption = (TextView) convertView.findViewById(R.id.caption);
        // holder.progressBar = (ProgressBar) convertView
        // .findViewById(R.id.progress);
        holder.caption.setText(getTitle(griRowItems.get(position)));
        holder.imageView.setOnClickListener(new OnImageClickListener(position));

        String tempStr = "assets://" + griRowItems.get(position);
        lazyLoading(imageLoader, tempStr, holder.imageView,
                options);
        return convertView;
    }

    private String getTitle(String fileName) {
        String trimmedFileNamewithExtension = fileName.substring(fileName.lastIndexOf("/") + 1);
        String trimmedFileName = trimmedFileNamewithExtension.substring(0, trimmedFileNamewithExtension.lastIndexOf('.'));
        if(trimmedFileName.equals("image_1")) {
            return "Meditation@Lalbaugh";
        } else if(trimmedFileName.equals("image_2")) {
            return "FunGames1";
        } else if(trimmedFileName.equals("image_3")) {
            return "Gomaatha Pooja";
        } else if(trimmedFileName.equals("image_4")) {
            return "Meditation@Lalbaugh1";
        } else if(trimmedFileName.equals("image_5")) {
            return "Independence Day Celebration1";
        } else if(trimmedFileName.equals("image_6")) {
            return "Independence Day Celebration2";
        } else if(trimmedFileName.equals("image_7")) {
            return "Independence Day Celebration3";
        } else if(trimmedFileName.equals("image_8")) {
            return "Independence Day Celebration4";
        } else if(trimmedFileName.equals("image_9")) {
            return "Moon light dinner";
        } else if(trimmedFileName.equals("image_10")) {
            return "Mud bath1";
        } else if(trimmedFileName.equals("image_11")) {
            return "Mud bath2";
        } else if(trimmedFileName.equals("image_12")) {
            return "Nature meditation";
        } else if(trimmedFileName.equals("image_13")) {
            return "Nature meditation1";
        } else if(trimmedFileName.equals("image_14")) {
            return "New batch inauguration";
        } else if(trimmedFileName.equals("image_15")) {
            return "New batch inauguration2";
        } else if(trimmedFileName.equals("image_16")) {
            return "Ragi ball food";
        } else if(trimmedFileName.equals("image_17")) {
            return "Rakshabandhana";
        } else if(trimmedFileName.equals("image_18")) {
            return "Raw food1";
        } else if(trimmedFileName.equals("image_19")) {
            return "Sahabhojana1";
        } else if(trimmedFileName.equals("image_20")) {
            return "Sahabhojana2";
        } else if(trimmedFileName.equals("image_21")) {
            return "Sahabhojana";
        } else if(trimmedFileName.equals("image_22")) {
            return "Spiritual picnic2";
        } else if(trimmedFileName.equals("image_23")) {
            return "Spritual Picnic";
        } else if(trimmedFileName.equals("image_24")) {
            return "Sun Rise Veekshane";
        } else if(trimmedFileName.equals("image_25")) {
            return "SuryaNamaskara1";
        } else if(trimmedFileName.equals("image_26")) {
            return "Swacchata Service";
        } else if(trimmedFileName.equals("image_27")) {
            return "Swamy Vivekananda Jayanthi";
        } else if(trimmedFileName.equals("image_28")) {
            return "Therapy1";
        } else if(trimmedFileName.equals("image_29")) {
            return "Therapy1";
        } else if(trimmedFileName.equals("image_30")) {
            return "Sakleshpur train trip";
        } else if(trimmedFileName.equals("image_31")) {
            return "Trekking";
        } else if(trimmedFileName.equals("image_32")) {
            return "Trekking1";
        } else if(trimmedFileName.equals("image_33")) {
            return "Trekking2";
        } else if(trimmedFileName.equals("image_34")) {
            return "Trekking3";
        } else if(trimmedFileName.equals("image_35")) {
            return "Trekking4";
        } else if(trimmedFileName.equals("image_36")) {
            return "Trekking5";
        } else if(trimmedFileName.equals("image_37")) {
            return "With Orphans";
        } else if(trimmedFileName.equals("image_38")) {
            return "Yoga family Tour1";
        } else if(trimmedFileName.equals("image_39")) {
            return "Yoga family Tour2";
        } else if(trimmedFileName.equals("image_40")) {
            return "Yoga family Tour3";
        } else if(trimmedFileName.equals("image_41")) {
            return "Yoga family Tour4";
        } else if(trimmedFileName.equals("image_42")) {
            return "Yogi as a farmer";
        } else {
            return "Image";
        }
    }

    class OnImageClickListener implements View.OnClickListener {

        int _postion;

        // constructor
        public OnImageClickListener(int position) {
            this._postion = position;
        }

        @Override
        public void onClick(View v) {
            // on selecting grid view image
            // launch full screen activity
            Intent i = new Intent(context, GalleryFullScreenPreview.class);
            i.putExtra("title",getTitle(griRowItems.get(_postion)));
            i.putExtra("itemuri", griRowItems.get(_postion));
            context.startActivity(i);
        }

    }

    @Override
    public int getCount() {
        return griRowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return griRowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView imageView;
        // ProgressBar progressBar;
        TextView caption;
        // DisplayImageOptions options;
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