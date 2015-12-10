package com.example.lcom53.picassotest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public String response = "{\"type\":\"getcntcs\",\"no\":17,\"cntcs\":[{\"friend\":\"a\",\"avatar\":null,\"fn\":\"a\",\"ln\":\"\",\"message\":null,\"email\":\"a@a.com\",\"joined_at\":1447959019825,\"show_date_created\":true,\"color\":\"#ffffff\"},{\"friend\":\"abc\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/22731029-94BA-4361-A7A7-FAAA8E11FBF7-2736-000002B280B29FC5.jpg\",\"fn\":\"hola\",\"ln\":\"chau\",\"message\":\"\",\"email\":\"federico.carrone+1@lambdaclass.com\",\"joined_at\":1447275957469,\"show_date_created\":true,\"color\":\"#00C09C\"},{\"friend\":\"b\",\"avatar\":null,\"fn\":\"b\",\"ln\":\"\",\"message\":null,\"email\":\"federico.carrone+b@lambdaclass.com\",\"joined_at\":1447276876396,\"show_date_created\":true,\"color\":\"ffffff\"},{\"friend\":\"c\",\"avatar\":null,\"fn\":\"c\",\"ln\":\"\",\"message\":null,\"email\":\"c@c.com\",\"joined_at\":1448030106171,\"show_date_created\":true,\"color\":\"#ffffff\"},{\"friend\":\"dhvanishah\",\"avatar\":\"\",\"fn\":\"Dhvani\",\"ln\":\"Shah\",\"message\":\"\",\"email\":\"laneetteam.dhvani@gmail.com\",\"joined_at\":1447675145001,\"show_date_created\":true,\"color\":\"#FF6060\"},{\"friend\":\"djckiss\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/EA64DDCC-0967-4C86-9227-396EBCE573D4-8938-000007F467BF3677djckiss.jpg\",\"fn\":\"Sikis\",\"ln\":\"Oneal\",\"message\":\"\",\"email\":\"djckiss@gmail.com\",\"joined_at\":1447169399393,\"show_date_created\":true,\"color\":\"#6208FF\"},{\"friend\":\"fedetest\",\"avatar\":\"\",\"fn\":\"Federico\",\"ln\":\"Carrone\",\"message\":\"\",\"email\":\"federico.carrone+test@lambdaclass.com\",\"joined_at\":1447776596897,\"show_date_created\":true,\"color\":\"#BC9C08\"},{\"friend\":\"fruzilah\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/132D0FD6-F99F-4D72-8047-DA151CE27EED-389-000000872E8A1879fruzilah.jpg\",\"fn\":\"Zilah\",\"ln\":\"Fru\",\"message\":\"\",\"email\":\"bessemzilah@yahoo.com\",\"joined_at\":1447463901735,\"show_date_created\":true,\"color\":\"#875FFF\"},{\"friend\":\"keka_moma\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/4572B1D3-0032-4D39-A29D-CD6811514ABD-226-000000252D6BBC70.jpg\",\"fn\":\"Keka\",\"ln\":\"Moma\",\"message\":\"\",\"email\":\"keka.moma@icloud.com\",\"joined_at\":1447792724143,\"show_date_created\":true,\"color\":\"#65E630\"},{\"friend\":\"kekamoma\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/78C2B11E-6BE0-4EE8-8EE3-F69EC55A2419-369-000000BF840E2E84kekamoma.jpg\",\"fn\":\"Keka\",\"ln\":\"Moma\",\"message\":\"Fear, you face it straight\",\"email\":\"keka.c.moma@gmail.com\",\"joined_at\":1447285405403,\"show_date_created\":true,\"color\":\"#8B0D52\"},{\"friend\":\"madhutest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/13A0BA1F-E611-4443-B620-E74FE232CCC7-4828-000004CD9778E624madhutest.jpg\",\"fn\":\"Madhu\",\"ln\":\"Chauhan\",\"message\":\"\",\"email\":\"chauhanmadhu.dev@gmail.com\",\"joined_at\":1447655247590,\"show_date_created\":true,\"color\":\"#B13BF5\"},{\"friend\":\"manuolmos\",\"avatar\":\"\",\"fn\":\"Manuel\",\"ln\":\"Olmos\",\"message\":\"\",\"email\":\"manuolmos88@gmail.com\",\"joined_at\":1447777054491,\"show_date_created\":true,\"color\":\"#2D52B5\"},{\"friend\":\"ndohmo20\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/6C0B5086-46AB-4067-A02D-83FF68398DFD-1014-000001B89C8C9297.jpg\",\"fn\":\"Ndohnwi\",\"ln\":\"Moma\",\"message\":\"\",\"email\":\"ndohmo@yahoo.com\",\"joined_at\":1447241821868,\"show_date_created\":true,\"color\":\"#BA1100\"},{\"friend\":\"rahitest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/76CD9E03-23E4-4503-971B-3214B38A8719-1106-00000161EDDA9099rahitest.jpg\",\"fn\":\"rahi\",\"ln\":\"test\",\"message\":\"\",\"email\":\"rahi.lanetteam@gmail.com\",\"joined_at\":1447130142307,\"show_date_created\":true,\"color\":\"#CF582C\"},{\"friend\":\"s_njem\",\"avatar\":\"\",\"fn\":\"Sikod\",\"ln\":\"Njem\",\"message\":\"\",\"email\":\"teghenicha@yahoo.com\",\"joined_at\":1447906641261,\"show_date_created\":true,\"color\":\"#D400DA\"},{\"friend\":\"sidtest\",\"avatar\":\"\",\"fn\":\"sid\",\"ln\":\"test\",\"message\":\"\",\"email\":\"sidsingh760@gmail.com\",\"joined_at\":1447121933765,\"show_date_created\":true,\"color\":\"#009FFF\"},{\"friend\":\"viraltest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/22499A06-CBB8-4DED-AAA9-2AF8BC546938-6776-00000B09733C5CEA.jpg\",\"fn\":\"Viral\",\"ln\":\"Test\",\"message\":\"\",\"email\":\"viral.lanet@gmail.com\",\"joined_at\":1447130633887,\"show_date_created\":true,\"color\":\"#FF1D12\"}],\"user\":\"anitest\",\"code\":0,\"id\":\"a23bf2\"}";
    ListView listView;
    private int mShortAnimationDuration;
    ImageLoader imageLoader = ImageLoader.getInstance();
    ImageLoaderConfiguration config;
    File customCacheDirectory;
    DisplayImageOptions options;
    private String CACHE_DIR = "MyCache";
    ImageView expanded_image;
    Toolbar toolbar;
    ActionBar actionBar;

    private Drawable mActionBarBackgroundDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        listView = (ListView) findViewById(R.id.listView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        preapreData();
        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);
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
        expanded_image = (ImageView) findViewById(R.id.expanded_image);
        mActionBarBackgroundDrawable = new ColorDrawable(getResources().getColor(R.color.privacy));
        mActionBarBackgroundDrawable.setAlpha(0);
        actionBar.setBackgroundDrawable(mActionBarBackgroundDrawable);
        mActionBarBackgroundDrawable.setCallback(new Drawable.Callback() {
            @Override
            public void invalidateDrawable(Drawable who) {
                actionBar.setBackgroundDrawable(who);
            }

            @Override
            public void scheduleDrawable(Drawable who, Runnable what, long when) {

            }

            @Override
            public void unscheduleDrawable(Drawable who, Runnable what) {

            }
        });

    }

    ArrayList<contact> contactArrayList = new ArrayList<>();

    private void preapreData() {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("cntcs");
            for (int i = 0; i < jsonArray.length(); i++) {
                contact c = new contact(jsonArray.getJSONObject(i));
                contactArrayList.add(c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ContactListAdapter adapter = new ContactListAdapter(this, contactArrayList, null);
        adapter.setImageClickListner(new ContactListAdapter.ImageClickListner() {
            @Override
            public void onImageClicked(final View v, String imageUrl) {
                if (!TextUtils.isEmpty(imageUrl) && !imageUrl.equals("null") && imageUrl != null) {
                    String fname = (String) v.getTag();
                    File file = new File(customCacheDirectory, fname);
                    if (file.exists()) {
                        imageLoader.displayImage("file://" + file.getAbsolutePath(), expanded_image, options, new ImageLoadingListener() {
                            @Override
                            public void onLoadingStarted(String s, View view) {

                            }

                            @Override
                            public void onLoadingFailed(String s, View view, FailReason failReason) {

                            }

                            @Override
                            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                                zoomImageFromThumb(v, bitmap);
                            }

                            @Override
                            public void onLoadingCancelled(String s, View view) {

                            }
                        });
                    }
                }
            }
        });
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    Animator mCurrentAnimator;

    /**
     * "Zooms" in a thumbnail view by assigning the high resolution image to a hidden "zoomed-in"
     * image view and animating its bounds to fit the entire activity content area. More
     * specifically:
     * <p/>
     * <ol>
     * <li>Assign the high-res image to the hidden "zoomed-in" (expanded) image view.</li>
     * <li>Calculate the starting and ending bounds for the expanded view.</li>
     * <li>Animate each of four positioning/sizing properties (X, Y, SCALE_X, SCALE_Y)
     * simultaneously, from the starting bounds to the ending bounds.</li>
     * <li>Zoom back out by running the reverse animation on click.</li>
     * </ol>
     *
     * @param thumbView  The thumbnail view to zoom in.
     * @param imageResId The high-resolution version of the image represented by the thumbnail.
     */
    private void zoomImageFromThumb(final View thumbView, Bitmap imageResId) {
        // If there's an animation in progress, cancel it immediately and proceed with this one.
        final Dialog dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        View view = View.inflate(this, R.layout.full_screen, null);
        dialog.setContentView(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
        dialog.show();
        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }
        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView = (ImageView) view.findViewById(R.id.ivFullScreen);
        expandedImageView.setImageBitmap(imageResId);
        // Calculate the starting and ending bounds for the zoomed-in image. This step
        // involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();
        // The start bounds are the global visible rectangle of the thumbnail, and the
        // final bounds are the global visible rectangle of the container view. Also
        // set the container view's offset as the origin for the bounds, since that's
        // the origin for the positioning animation properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container).getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);
        // Adjust the start bounds to be the same aspect ratio as the final bounds using the
        // "center crop" technique. This prevents undesirable stretching during the animation.
        // Also calculate the start scaling factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation begins,
        // it will position the zoomed-in view in the place of the thumbnail.
        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations to the top-left corner of
        // the zoomed-in view (the default is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and scale properties
        // (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            set
                    .play(ObjectAnimator.ofFloat(expandedImageView, View.X, startBounds.left,
                            finalBounds.left))
                    .with(ObjectAnimator.ofFloat(expandedImageView, View.Y, startBounds.top,
                            finalBounds.top))
                    .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X, startScale, 1f))
                    .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_Y, startScale, 1f));
        }
        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                hideStatusBar();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator = null;
            }
        });
        set.start();
        mCurrentAnimator = set;

        // Upon clicking the zoomed-in image, it should zoom back down to the original bounds
        // and show the thumbnail instead of the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator != null) {
                    mCurrentAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel, back to their
                // original values.
                AnimatorSet set = new AnimatorSet();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                    set
                            .play(ObjectAnimator.ofFloat(expandedImageView, View.X, startBounds.left))
                            .with(ObjectAnimator.ofFloat(expandedImageView, View.Y, startBounds.top))
                            .with(ObjectAnimator
                                    .ofFloat(expandedImageView, View.SCALE_X, startScaleFinal))
                            .with(ObjectAnimator
                                    .ofFloat(expandedImageView, View.SCALE_Y, startScaleFinal));
                }
                set.setDuration(mShortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        dialog.dismiss();
                        mCurrentAnimator = null;
                        ShowStatusBar();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        dialog.dismiss();
                        mCurrentAnimator = null;
                        ShowStatusBar();
                    }
                });
                set.start();
                mCurrentAnimator = set;
            }
        });
    }

    public void hideStatusBar() {
//        if (Build.VERSION.SDK_INT < 16) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        } else {
//            View decorView = getWindow().getDecorView();
//// Hide the status bar.
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//// Remember that you should never show the action bar if the
//// status bar is hidden, so hide that too if necessary.
//            actionBar.hide();
//        }
        mActionBarBackgroundDrawable.setAlpha(0);
        toolbar.invalidate();
    }

    public void ShowStatusBar() {
//        if (Build.VERSION.SDK_INT < 16) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
//        } else {
//            View decorView = getWindow().getDecorView();
// Hide the status bar.
//            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
//            actionBar.show();
//        toolbar.setVisibility(View.VISIBLE);
        mActionBarBackgroundDrawable.setAlpha(1);
        toolbar.invalidate();

//    }
    }
}
