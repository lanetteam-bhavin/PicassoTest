package com.example.lcom53.picassotest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    ActionBar actionBar;
    public String response = "{\"type\":\"getcntcs\",\"no\":15,\"cntcs\":[{\"friend\":\"anitest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/21201DF0-9530-46B7-9347-41C5A8CBD57C-2441-0000043381359096anitest.jpg\",\"fn\":\"ani\",\"ln\":\"Loop\",\"message\":\"adsadsasasasfasdfasdfl;kjlsdf\",\"email\":\"lanetteam.anish@gmail.com\",\"joined_at\":1447129400309,\"show_date_created\":true,\"color\":\"#A822A1\"},{\"friend\":\"b\",\"avatar\":null,\"fn\":\"b\",\"ln\":\"\",\"message\":null,\"email\":\"federico.carrone+b@lambdaclass.com\",\"joined_at\":1447276876396,\"show_date_created\":true,\"color\":\"ffffff\"},{\"friend\":\"djckiss\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/EA64DDCC-0967-4C86-9227-396EBCE573D4-8938-000007F467BF3677djckiss.jpg\",\"fn\":\"Sikis\",\"ln\":\"Oneal\",\"message\":\"\",\"email\":\"djckiss@gmail.com\",\"joined_at\":1447169399393,\"show_date_created\":true,\"color\":\"#6208FF\"},{\"friend\":\"fedetest\",\"avatar\":\"\",\"fn\":\"Federico\",\"ln\":\"Carrone\",\"message\":\"\",\"email\":\"federico.carrone+test@lambdaclass.com\",\"joined_at\":1447776596897,\"show_date_created\":true,\"color\":\"#BC9C08\"},{\"friend\":\"fruzilah\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/132D0FD6-F99F-4D72-8047-DA151CE27EED-389-000000872E8A1879fruzilah.jpg\",\"fn\":\"Zilah\",\"ln\":\"Fru\",\"message\":\"\",\"email\":\"bessemzilah@yahoo.com\",\"joined_at\":1447463901735,\"show_date_created\":true,\"color\":\"#875FFF\"},{\"friend\":\"keka_moma\",\"avatar\":\"\",\"fn\":\"Keka\",\"ln\":\"Moma\",\"message\":\"\",\"email\":\"keka.moma@icloud.com\",\"joined_at\":1447792724143,\"show_date_created\":true,\"color\":\"#E80C97\"},{\"friend\":\"kekamoma\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/394C428C-4E33-4B41-B988-6B09587AE5AA-478-00000097AC50070Ckekamoma.jpg\",\"fn\":\"Keka\",\"ln\":\"Moma\",\"message\":\"Fear, you face it straight\",\"email\":\"keka.c.moma@gmail.com\",\"joined_at\":1447285405403,\"show_date_created\":true,\"color\":\"#19AE0A\"},{\"friend\":\"madhutest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/13A0BA1F-E611-4443-B620-E74FE232CCC7-4828-000004CD9778E624madhutest.jpg\",\"fn\":\"Madhu\",\"ln\":\"Chauhan\",\"message\":\"\",\"email\":\"chauhanmadhu.dev@gmail.com\",\"joined_at\":1447655247590,\"show_date_created\":true,\"color\":\"#F593D1\"},{\"friend\":\"manuolmos\",\"avatar\":\"\",\"fn\":\"Manuel\",\"ln\":\"Olmos\",\"message\":\"\",\"email\":\"manuolmos88@gmail.com\",\"joined_at\":1447777054491,\"show_date_created\":true,\"color\":\"#2D52B5\"},{\"friend\":\"ndohmo\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/3CDE088B-69CC-4CB7-A32F-2A82E3E124DA-1959-000003F96DE850EA.jpg\",\"fn\":\"Ndohnwi\",\"ln\":\"Moma\",\"message\":\"\",\"email\":\"ndohmo@gmail.com\",\"joined_at\":1448418188600,\"show_date_created\":true,\"color\":\"#2B44B5\"},{\"friend\":\"ndohmo20\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/6C0B5086-46AB-4067-A02D-83FF68398DFD-1014-000001B89C8C9297.jpg\",\"fn\":\"Ndohnwi\",\"ln\":\"Moma\",\"message\":\"\",\"email\":\"ndohmo@yahoo.com\",\"joined_at\":1447241821868,\"show_date_created\":true,\"color\":\"#BA32A1\"},{\"friend\":\"rahitest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/76CD9E03-23E4-4503-971B-3214B38A8719-1106-00000161EDDA9099rahitest.jpg\",\"fn\":\"rahi\",\"ln\":\"test\",\"message\":\"\",\"email\":\"rahi.lanetteam@gmail.com\",\"joined_at\":1447130142307,\"show_date_created\":true,\"color\":\"#666605\"},{\"friend\":\"s_njem\",\"avatar\":\"\",\"fn\":\"Sikod\",\"ln\":\"Njem\",\"message\":\"\",\"email\":\"teghenicha@yahoo.com\",\"joined_at\":1447906641261,\"show_date_created\":true,\"color\":\"#D400DA\"},{\"friend\":\"sohroyale\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/8167E803-1835-45EC-95E3-ABB45795464F-4178-0000073E2FDD7E94.jpg\",\"fn\":\"Soh\",\"ln\":\"Royale\",\"message\":\"\",\"email\":\"soh2.0royale@yahoo.com\",\"joined_at\":1448743757352,\"show_date_created\":true,\"color\":\"#FF6E27\"},{\"friend\":\"viraltest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/22499A06-CBB8-4DED-AAA9-2AF8BC546938-6776-00000B09733C5CEA.jpg\",\"fn\":\"Viral\",\"ln\":\"Test\",\"message\":\"\",\"email\":\"viral.lanet@gmail.com\",\"joined_at\":1447130633887,\"show_date_created\":true,\"color\":\"#FF1D12\"},{\"friend\":\"sidi#sidtest\",\"fn\":\"sidi\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/65C135F8-A8A4-4438-A64F-956A8E871ED2-5576-000021449149AE97sidtest.jpg\"},{\"friend\":\"anothercircle#kekamoma\",\"fn\":\"Another Circle\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/6447AFE1-AAE4-45E6-9358-7A191417D70B-528-000000EC3AB02EBCkekamoma.jpg\"},{\"friend\":\"bold#kekamoma\",\"fn\":\"Bold\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/981AE136-DAB4-408A-8BA9-8C40E40C49AD-485-0000010CEE5BD2C8kekamoma.jpg\"},{\"friend\":\"final#anitest\",\"fn\":\"Final\",\"avatar\":\"\"},{\"friend\":\"iceream#anitest\",\"fn\":\"Iceream\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/459DCD9A-4B11-4B91-B81A-69E1F441B9D9-7071-00000BB163B77212anitest.jpg\"},{\"friend\":\"ios#rahitest\",\"fn\":\"ios\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/5D4A5367-50D4-479B-930D-E052F59299AF-10282-00001526B1F12EE4rahitest.jpg\"},{\"friend\":\"kiyu#anitest\",\"fn\":\"Kiyu\",\"avatar\":\"\"},{\"friend\":\"me#rahitest\",\"fn\":\"me\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/7FE59A35-AB29-415C-9F78-66CFD1E999C2-43665-00005BC47B874BC4rahitest.jpg\"},{\"friend\":\"mycircle#kekamoma\",\"fn\":\"My Circle One\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/81F378F7-072A-445C-9626-0EA1BFF2EF9D-528-000000EB9B6C4183kekamoma.jpg\"},{\"friend\":\"nrsu#anitest\",\"fn\":\"Nrsu \",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/39D59C57-140A-445C-A649-D0E007C33FE3-7071-00000BB5889FC8B0anitest.jpg\"},{\"friend\":\"paneri#rahitest\",\"fn\":\"paneri\",\"avatar\":\"\"},{\"friend\":\"shiv#anitest\",\"fn\":\"Shiv\",\"avatar\":\"\"},{\"friend\":\"shivani#anitest\",\"fn\":\"Shivani\",\"avatar\":\"\"},{\"friend\":\"testbannernotif#madhutest\",\"fn\":\"testBannerNotif\",\"avatar\":\"\"},{\"friend\":\"tiger#rahitest\",\"fn\":\"tiger\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/1002247E-000D-4621-A4C2-E46D38FF293B-353-0000004A36D20C46rahitest.jpg\"},{\"friend\":\"uhd#rahitest\",\"fn\":\"Uhd\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/144F87FE-9B6F-4C39-AD30-92E824FF00AD-897-000000CC762BCB06rahitest.jpg\"},{\"friend\":\"umm#rahitest\",\"fn\":\"umm\",\"avatar\":\"\"},{\"friend\":\"vb#anitest\",\"fn\":\"Vb\",\"avatar\":\"\"},{\"friend\":\"yr#anitest\",\"fn\":\"Yr\",\"avatar\":\"\"}],\"user\":\"sidtest\",\"code\":0,\"id\":\"a23bf2\"}";
    ArrayList<contact> contactArrayList = new ArrayList<>();
    private int mShortAnimationDuration;
    ImageLoader imageLoader = ImageLoader.getInstance();
    ImageLoaderConfiguration config;
    File customCacheDirectory;
    DisplayImageOptions options;
    private String CACHE_DIR = "MyCache";
    ImageView expanded_image;
    Spinner spinner;
    Bitmap bmp;
    boolean isShow = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        actionBar = getSupportActionBar();
        actionBar.setTitle("This is well");
        listView = (ListView) findViewById(R.id.listView);
        expanded_image = (ImageView) findViewById(R.id.expanded_image);
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
        spinner = (Spinner) findViewById(R.id.spinner);
        String[] options1 = {"CENTER_CROP", "CENTER_INSIDE", "CENTER", "FIT_CENTER", "FIT_XY", "MATRIX", "FIT_START", "FIT_END"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_list_item_single_choice, Arrays.asList(options1));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (isShow) {
//                    if (Build.VERSION.SDK_INT < 16) {
//                        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                    } else {
//                        View decorView = getWindow().getDecorView();
//                        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//                        decorView.setSystemUiVisibility(uiOptions);
//                    }
//                } else {
//                    if (Build.VERSION.SDK_INT < 16) {
//                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                    } else {
//                        View decorView = getWindow().getDecorView();
//                        int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
//                        decorView.setSystemUiVisibility(uiOptions);
//                    }
//                }
//                isShow = !isShow;
                switch (position) {
                    case 0:
                        expanded_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        expanded_image.setImageBitmap(bmp);
                        break;
                    case 1:
                        expanded_image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        expanded_image.setImageBitmap(bmp);
                        break;
                    case 2:
                        expanded_image.setScaleType(ImageView.ScaleType.CENTER);
                        expanded_image.setImageBitmap(bmp);
                        break;
                    case 3:
                        expanded_image.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        expanded_image.setImageBitmap(bmp);
                        break;
                    case 4:
                        expanded_image.setScaleType(ImageView.ScaleType.FIT_XY);
                        expanded_image.setImageBitmap(bmp);
                        break;
                    case 5:
                        expanded_image.setScaleType(ImageView.ScaleType.MATRIX);
                        expanded_image.setImageBitmap(bmp);
                        break;
                    case 6:
                        expanded_image.setScaleType(ImageView.ScaleType.FIT_START);
                        expanded_image.setImageBitmap(bmp);
                        break;
                    case 7:
                        expanded_image.setScaleType(ImageView.ScaleType.FIT_END);
                        expanded_image.setImageBitmap(bmp);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        imageLoader.init(config);
        customCacheDirectory = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/" + CACHE_DIR);
        preapreData();
        File file = new File(customCacheDirectory, "anitest_21201DF0-9530-46B7-9347-41C5A8CBD57C-2441-0000043381359096anitest.jpg.jpg");
        imageLoader.displayImage("https://s3.amazonaws.com/s3-imxam-development/21201DF0-9530-46B7-9347-41C5A8CBD57C-2441-0000043381359096anitest.jpg", expanded_image, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {

            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                expanded_image.setImageBitmap(bitmap);
                bmp = bitmap;
            }

            @Override
            public void onLoadingCancelled(String s, View view) {

            }
        });
//        View decorView = getWindow().getDecorView();
//        decorView.setOnSystemUiVisibilityChangeListener
//                (new View.OnSystemUiVisibilityChangeListener() {
//                    @Override
//                    public void onSystemUiVisibilityChange(int visibility) {
//                        // Note that system bars will only be "visible" if none of the
//                        // LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags are set.
//                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
//                            // TODO: The system bars are visible. Make any desired
//                            actionBar.show();
//                        } else {
//                            // TODO: The system bars are NOT visible. Make any desired
//                            actionBar.hide();
//                        }
//                    }
//                });

    }

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
                    } else {
                        imageLoader.displayImage(imageUrl, expanded_image, options, new ImageLoadingListener() {
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
//        listView.setVisibility(View.GONE);
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
        final Dialog dialog = new Dialog(this, R.style.DialogTheme);
//        if (Build.VERSION.SDK_INT < 16) {
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
//        } else {
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//        }
//        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        View view = View.inflate(this, R.layout.full_screen, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setContentView(view, params);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog1) {
                showStatuBar(dialog);
            }
        });
        hideStatusBar(dialog);
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            PropertyValuesHolder pchX = PropertyValuesHolder.ofFloat(View.X, startBounds.left, finalBounds.left);
            PropertyValuesHolder pchY = PropertyValuesHolder.ofFloat(View.Y, startBounds.top, finalBounds.top);
            PropertyValuesHolder pchScaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, startScale, 1f);
            PropertyValuesHolder pchScaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, startScale, 1f);
            ObjectAnimator.ofPropertyValuesHolder(expandedImageView, pchX, pchY, pchScaleX, pchScaleY).start();
        }
        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
//                hideStatusBar(dialog);
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
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        dialog.dismiss();
                        mCurrentAnimator = null;
                    }
                });
                set.start();
                mCurrentAnimator = set;
            }
        });
    }

    public void hideStatusBar(Dialog dialog) {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;//View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    public void showStatuBar(Dialog dialog) {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        } else {
            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(0);
        }
    }
}
