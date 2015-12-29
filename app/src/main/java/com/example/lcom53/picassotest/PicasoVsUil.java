package com.example.lcom53.picassotest;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Picasso;

import java.io.File;

public class PicasoVsUil extends AppCompatActivity {
    // Content View Elements

    private ImageView mIvPicasso;
    private TextView mTvPicasso;
    private CircularImageView mIvUil;
    private TextView mTvUil;
    private ImageView mivUil1;
    String picUrl = null, localStorage = null;
    // End Of Content View Elements
    ImageLoader imageLoader = ImageLoader.getInstance();
    ImageLoaderConfiguration config;
    File customCacheDirectory;
    DisplayImageOptions options;
    private String CACHE_DIR = "MyCache";
    private String TAG = PicasoVsUil.class.getSimpleName();
    AppBarLayout appbar;
    ImageView img_user_photo;
    Point size = new Point();
    int imgMaxHeight = 0;

    private void bindViews() {
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        mIvPicasso = (ImageView) findViewById(R.id.ivPicasso);
        mTvPicasso = (TextView) findViewById(R.id.tvPicasso);
        mIvUil = (CircularImageView) findViewById(R.id.ivUil);
        mTvUil = (TextView) findViewById(R.id.tvUil);
        mivUil1 = (ImageView) findViewById(R.id.ivUil1);
        img_user_photo = (ImageView) findViewById(R.id.img_user_photo);
        DisplayMetrics metrics = new DisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            display.getSize(size);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picaso_vs_uil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ProgressDialog progressDialog = new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bindViews();
        picUrl = getIntent().getStringExtra("Url");
        localStorage = getIntent().getStringExtra("local");
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.xml_src_image)
                .showImageForEmptyUri(R.drawable.xml_src_image)
                .showImageOnFail(R.drawable.xml_src_image)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        config = new ImageLoaderConfiguration.Builder(this).build();
        imageLoader.init(config);
        customCacheDirectory = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/" + CACHE_DIR);
        Picasso.with(this).load(picUrl).centerCrop().resizeDimen(R.dimen.dim65, R.dimen.dim65).into(mIvPicasso);
        File file = new File(customCacheDirectory, localStorage);
        imageLoader.displayImage("file://" + file.getAbsolutePath(), mIvUil, options);
        imageLoader.displayImage("file://" + file.getAbsolutePath(), mivUil1, options);
        imageLoader.loadImage("file://" + file.getAbsolutePath(), options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {

            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                setBitmapForUserImage(bitmap, true);
            }

            @Override
            public void onLoadingCancelled(String s, View view) {

            }
        });
    }

    boolean isFirstTime = false;

    private void setBitmapForUserImage(Bitmap bitmap, boolean overrideRealPath) {
        if (img_user_photo != null) img_user_photo.setImageBitmap(bitmap);


        if (isFirstTime) {
            LoadImageInUserPhoto taskPhoto = new LoadImageInUserPhoto(overrideRealPath, true);
            taskPhoto.execute(bitmap);
        } else {
            LoadImageInUserPhoto taskPhoto = new LoadImageInUserPhoto(overrideRealPath);
            taskPhoto.execute(bitmap);
        }
    }

    public class LoadImageInUserPhoto extends AsyncTask<Bitmap, Void, Bitmap> {
        boolean moverrideRealPath;
        Bitmap Localbitmap;
        int imageMaxHeight1 = 0;
        boolean mShouldCollapse = false;

        LoadImageInUserPhoto(boolean overrideRealPath) {
            moverrideRealPath = overrideRealPath;
        }

        public LoadImageInUserPhoto(boolean overrideRealPath, boolean shouldCollapse) {
            moverrideRealPath = overrideRealPath;
            mShouldCollapse = shouldCollapse;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap1) {

//            imgv_user_photo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            img_user_photo.setImageBitmap(bitmap1);
            //imageMaxHeight1 = imgv_user_photo.getDrawable().getIntrinsicHeight();
            Log.v(TAG, "we set image max Height @458:" + imageMaxHeight1);
            if (imageMaxHeight1 > 0) {
                resizeAppBar(imageMaxHeight1);
            }
        }

        @Override
        protected Bitmap doInBackground(Bitmap... params) {
            Localbitmap = params[0];

            int width = size.x;
            int height = size.y;
            int minHeight = (int) (height * 0.3);
            Log.v(TAG, "Width --- " + width + ":and height is:" + height);
            Log.v(TAG, "Bitmap Width --- " + Localbitmap.getWidth() + ":and height is:" + Localbitmap.getHeight());
//            Log.v(TAG, "Drawable width ---" + imgv_user_photo.getDrawable().getIntrinsicWidth());
            float ratio = ((float) width) / Localbitmap.getWidth();
            float imageRatio = Localbitmap.getHeight() / (float) Localbitmap.getWidth();
            Log.d(TAG, "Ratio  :" + ratio + ":ImageRatio:" + imageRatio);
            if (ratio < 1) {
                imgMaxHeight = (int) (imgMaxHeight * ratio);
                imgMaxHeight = imgMaxHeight - 150;
            }
            Matrix m = new Matrix();
            float newHeight = Localbitmap.getHeight() * ratio;
            float newWidth = width;
            Log.d(TAG, "New Height :" + newHeight + ":newWidth:" + newWidth);
            m.setRectToRect(new RectF(0, 0, Localbitmap.getWidth(), Localbitmap.getHeight()), new RectF(0, 0, newWidth, newHeight), Matrix.ScaleToFit.CENTER);
            Bitmap bitmap1 = Bitmap.createBitmap(Localbitmap, 0, 0, Localbitmap.getWidth(), Localbitmap.getHeight(), m, true);
            imageMaxHeight1 = (int) newHeight;
            if (imageMaxHeight1 >= height) {
                imageMaxHeight1 = (int) (height * 0.8);
            }
            if (imageMaxHeight1 < minHeight) {
                imageMaxHeight1 = minHeight;
            }
            return bitmap1;
        }
    }

    private void resizeAppBar(int heightResize) {
        int appBarHeightResize = heightResize;
        Log.d(TAG, "Resize App Bar :" + appBarHeightResize + ":" + heightResize);
        Log.d(TAG, "Changed Resize App Bar :" + appBarHeightResize);
        if (appbar != null) {
            ResizeAnimation resizeAnimation = new ResizeAnimation(appbar, appBarHeightResize);
            AccelerateInterpolator interpolator = new AccelerateInterpolator(0.8f);
            resizeAnimation.setInterpolator(interpolator);
            resizeAnimation.setDuration(1200);
            resizeAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            appbar.startAnimation(resizeAnimation);
        }
    }
}
