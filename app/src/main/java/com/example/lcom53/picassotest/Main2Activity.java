package com.example.lcom53.picassotest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
    public String response = "{\"type\":\"getcntcs\",\"no\":17,\"cntcs\":[{\"friend\":\"anitest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/ECCDDC4B-37DB-4B01-B072-BD7C35D420FD-1561-000001BBC9FC0F45anitest.jpg\",\"fn\":\"ani\",\"ln\":\"Loop\",\"message\":\"kajSHD K ASKFDJ HASKDFJH ASDKFJHAS DFKHJASD FKJAHSDF KSAJDHF ASKDFHJAS DKFJHASDF KJAHSDF KASDJFFHJASDF\",\"email\":\"lanetteam.anish@gmail.com\",\"joined_at\":1447129400309,\"show_date_created\":true,\"color\":\"#2DA887\"},{\"friend\":\"bhavindoshi\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/twko98A9nLwlIcai.jpg\",\"fn\":\"Bhavin hdhhddh\",\"ln\":\"Doshi\",\"message\":\"All will well !\",\"email\":\"bhavin.doshi1989@gmail.com\",\"joined_at\":1449038035286,\"show_date_created\":true,\"color\":\"#9f211b\"},{\"friend\":\"dhvanishah\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/64CFE275-2A58-4FA8-8786-8DE6DE5C61C3-2118-00000271618A1C8Edhvanishah.jpg\",\"fn\":\"Dhvani\",\"ln\":\"Shah\",\"message\":\"hello how are you\",\"email\":\"laneetteam.dhvani@gmail.com\",\"joined_at\":1447675145001,\"show_date_created\":true,\"color\":\"#FF6060\"},{\"friend\":\"djckiss\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/81FD0935-A1FC-444C-BDE7-11A137EA2FA0-4180-0000046A2EF9EB82djckiss.jpg\",\"fn\":\"Sikis\",\"ln\":\"Oneal\",\"message\":\"\",\"email\":\"djckiss@gmail.com\",\"joined_at\":1447169399393,\"show_date_created\":true,\"color\":\"#6208FF\"},{\"friend\":\"f\",\"avatar\":null,\"fn\":\"f\",\"ln\":\"\",\"message\":null,\"email\":\"f@f.com\",\"joined_at\":1449512176671,\"show_date_created\":true,\"color\":\"#ffffff\"},{\"friend\":\"fede\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/7148AAA4-261F-457F-8D34-7CEB9513CC0E-2694-000002A5CA879F20.jpg\",\"fn\":\"fede v\",\"ln\":\"carrone\",\"message\":\"\",\"email\":\"federico.carrone@lambdaclass.com\",\"joined_at\":1447272649828,\"show_date_created\":true,\"color\":\"#B54328\"},{\"friend\":\"fedetest\",\"avatar\":\"\",\"fn\":\"Federico\",\"ln\":\"Carrone\",\"message\":\"\",\"email\":\"federico.carrone+test@lambdaclass.com\",\"joined_at\":1447776596897,\"show_date_created\":true,\"color\":\"#BC9C08\"},{\"friend\":\"fruzilah\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/132D0FD6-F99F-4D72-8047-DA151CE27EED-389-000000872E8A1879fruzilah.jpg\",\"fn\":\"Zilah\",\"ln\":\"Fru\",\"message\":\"\",\"email\":\"bessemzilah@yahoo.com\",\"joined_at\":1447463901735,\"show_date_created\":true,\"color\":\"#875FFF\"},{\"friend\":\"keka_moma\",\"avatar\":\"\",\"fn\":\"Keka\",\"ln\":\"Moma\",\"message\":\"\",\"email\":\"keka.moma@icloud.com\",\"joined_at\":1447792724143,\"show_date_created\":true,\"color\":\"#A4590D\"},{\"friend\":\"ndohmo\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/D7845A83-E7C1-4708-A6C4-3A95ABC2CD42-764-0000012ACA854AE9.jpg\",\"fn\":\"Ndohnwi\",\"ln\":\"Moma\",\"message\":\"\",\"email\":\"ndohmo@gmail.com\",\"joined_at\":1449026687003,\"show_date_created\":true,\"color\":\"#FD1756\"},{\"friend\":\"niteshpandav\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/AyHzUgQdwLdNE9mY.jpg\",\"fn\":\"Nitesh\",\"ln\":\"Pandav\",\"message\":\"\",\"email\":\"nitesh.lanetteam@gmail.com\",\"joined_at\":1449221254603,\"show_date_created\":true,\"color\":\"#a96676\"},{\"friend\":\"rahitest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/9E0D9945-95C3-4F44-8360-C8689574EA60-10896-00000E3C27F6479Erahitest.jpg\",\"fn\":\"rahi\",\"ln\":\"test\",\"message\":\"asdfasdfa sdfasdf asdf asdf a\",\"email\":\"rahi.lanetteam@gmail.com\",\"joined_at\":1447130142307,\"show_date_created\":true,\"color\":\"#666605\"},{\"friend\":\"rajtest\",\"avatar\":\"\",\"fn\":\"raj\",\"ln\":\"kapoor\",\"message\":\"\",\"email\":\"rajkapoordev@gmail.com\",\"joined_at\":1448532730950,\"show_date_created\":true,\"color\":\"#F443C0\"},{\"friend\":\"shivani_chauhan\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/VWgw3rVxtIZlIttO.jpg\",\"fn\":\"Shivani\",\"ln\":\"Chauhan\",\"message\":\"\",\"email\":\"shivanic1986@gmail.com\",\"joined_at\":1449196652469,\"show_date_created\":true,\"color\":\"\"},{\"friend\":\"toramora\",\"avatar\":null,\"fn\":\"Tora\",\"ln\":\"Mora\",\"message\":null,\"email\":\"lanetteam.bhavin@gmail.com\",\"joined_at\":1449209546193,\"show_date_created\":true,\"color\":\"#5034a0\"},{\"friend\":\"udayanga\",\"avatar\":null,\"fn\":\"udayanga\",\"ln\":\"senarath\",\"message\":null,\"email\":\"udaya.se@gmail.com\",\"joined_at\":1448461768812,\"show_date_created\":true,\"color\":\"#ffffff\"},{\"friend\":\"viraltest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/2346B6AD-C1EE-47FB-9A68-CFCAB6D4C7F7-1680-000001B41980B9EBviraltest.jpg\",\"fn\":\"Viral\",\"ln\":\"Test\",\"message\":\"Hello how are you\",\"email\":\"viral.lanet@gmail.com\",\"joined_at\":1447130633887,\"show_date_created\":true,\"color\":\"#FF1D12\"},{\"friend\":\"anitest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/ECCDDC4B-37DB-4B01-B072-BD7C35D420FD-1561-000001BBC9FC0F45anitest.jpg\",\"fn\":\"ani\",\"ln\":\"Loop\",\"message\":\"kajSHD K ASKFDJ HASKDFJH ASDKFJHAS DFKHJASD FKJAHSDF KSAJDHF ASKDFHJAS DKFJHASDF KJAHSDF KASDJFFHJASDF\",\"email\":\"lanetteam.anish@gmail.com\",\"joined_at\":1447129400309,\"show_date_created\":true,\"color\":\"#2DA887\"},{\"friend\":\"bhavindoshi\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/twko98A9nLwlIcai.jpg\",\"fn\":\"Bhavin hdhhddh\",\"ln\":\"Doshi\",\"message\":\"All will well !\",\"email\":\"bhavin.doshi1989@gmail.com\",\"joined_at\":1449038035286,\"show_date_created\":true,\"color\":\"#9f211b\"},{\"friend\":\"dhvanishah\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/64CFE275-2A58-4FA8-8786-8DE6DE5C61C3-2118-00000271618A1C8Edhvanishah.jpg\",\"fn\":\"Dhvani\",\"ln\":\"Shah\",\"message\":\"hello how are you\",\"email\":\"laneetteam.dhvani@gmail.com\",\"joined_at\":1447675145001,\"show_date_created\":true,\"color\":\"#FF6060\"},{\"friend\":\"djckiss\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/81FD0935-A1FC-444C-BDE7-11A137EA2FA0-4180-0000046A2EF9EB82djckiss.jpg\",\"fn\":\"Sikis\",\"ln\":\"Oneal\",\"message\":\"\",\"email\":\"djckiss@gmail.com\",\"joined_at\":1447169399393,\"show_date_created\":true,\"color\":\"#6208FF\"},{\"friend\":\"f\",\"avatar\":null,\"fn\":\"f\",\"ln\":\"\",\"message\":null,\"email\":\"f@f.com\",\"joined_at\":1449512176671,\"show_date_created\":true,\"color\":\"#ffffff\"},{\"friend\":\"fede\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/7148AAA4-261F-457F-8D34-7CEB9513CC0E-2694-000002A5CA879F20.jpg\",\"fn\":\"fede v\",\"ln\":\"carrone\",\"message\":\"\",\"email\":\"federico.carrone@lambdaclass.com\",\"joined_at\":1447272649828,\"show_date_created\":true,\"color\":\"#B54328\"},{\"friend\":\"fedetest\",\"avatar\":\"\",\"fn\":\"Federico\",\"ln\":\"Carrone\",\"message\":\"\",\"email\":\"federico.carrone+test@lambdaclass.com\",\"joined_at\":1447776596897,\"show_date_created\":true,\"color\":\"#BC9C08\"},{\"friend\":\"fruzilah\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/132D0FD6-F99F-4D72-8047-DA151CE27EED-389-000000872E8A1879fruzilah.jpg\",\"fn\":\"Zilah\",\"ln\":\"Fru\",\"message\":\"\",\"email\":\"bessemzilah@yahoo.com\",\"joined_at\":1447463901735,\"show_date_created\":true,\"color\":\"#875FFF\"},{\"friend\":\"keka_moma\",\"avatar\":\"\",\"fn\":\"Keka\",\"ln\":\"Moma\",\"message\":\"\",\"email\":\"keka.moma@icloud.com\",\"joined_at\":1447792724143,\"show_date_created\":true,\"color\":\"#A4590D\"},{\"friend\":\"ndohmo\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/D7845A83-E7C1-4708-A6C4-3A95ABC2CD42-764-0000012ACA854AE9.jpg\",\"fn\":\"Ndohnwi\",\"ln\":\"Moma\",\"message\":\"\",\"email\":\"ndohmo@gmail.com\",\"joined_at\":1449026687003,\"show_date_created\":true,\"color\":\"#FD1756\"},{\"friend\":\"niteshpandav\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/AyHzUgQdwLdNE9mY.jpg\",\"fn\":\"Nitesh\",\"ln\":\"Pandav\",\"message\":\"\",\"email\":\"nitesh.lanetteam@gmail.com\",\"joined_at\":1449221254603,\"show_date_created\":true,\"color\":\"#a96676\"},{\"friend\":\"rahitest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/9E0D9945-95C3-4F44-8360-C8689574EA60-10896-00000E3C27F6479Erahitest.jpg\",\"fn\":\"rahi\",\"ln\":\"test\",\"message\":\"asdfasdfa sdfasdf asdf asdf a\",\"email\":\"rahi.lanetteam@gmail.com\",\"joined_at\":1447130142307,\"show_date_created\":true,\"color\":\"#666605\"},{\"friend\":\"rajtest\",\"avatar\":\"\",\"fn\":\"raj\",\"ln\":\"kapoor\",\"message\":\"\",\"email\":\"rajkapoordev@gmail.com\",\"joined_at\":1448532730950,\"show_date_created\":true,\"color\":\"#F443C0\"},{\"friend\":\"shivani_chauhan\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/VWgw3rVxtIZlIttO.jpg\",\"fn\":\"Shivani\",\"ln\":\"Chauhan\",\"message\":\"\",\"email\":\"shivanic1986@gmail.com\",\"joined_at\":1449196652469,\"show_date_created\":true,\"color\":\"\"},{\"friend\":\"toramora\",\"avatar\":null,\"fn\":\"Tora\",\"ln\":\"Mora\",\"message\":null,\"email\":\"lanetteam.bhavin@gmail.com\",\"joined_at\":1449209546193,\"show_date_created\":true,\"color\":\"#5034a0\"},{\"friend\":\"udayanga\",\"avatar\":null,\"fn\":\"udayanga\",\"ln\":\"senarath\",\"message\":null,\"email\":\"udaya.se@gmail.com\",\"joined_at\":1448461768812,\"show_date_created\":true,\"color\":\"#ffffff\"},{\"friend\":\"viraltest\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/2346B6AD-C1EE-47FB-9A68-CFCAB6D4C7F7-1680-000001B41980B9EBviraltest.jpg\",\"fn\":\"Viral\",\"ln\":\"Test\",\"message\":\"Hello how are you\",\"email\":\"viral.lanet@gmail.com\",\"joined_at\":1447130633887,\"show_date_created\":true,\"color\":\"#FF1D12\"},{\"friend\":\"dear#sidtest\",\"fn\":\"dear\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/18rFN75wdqZFSDXx.jpg\"},{\"friend\":\"fggg#sidtest\",\"fn\":\"fggg\",\"avatar\":\"\"},{\"friend\":\"hhhhhh#sidtest\",\"fn\":\"hhhhhh\",\"avatar\":\"\"},{\"friend\":\"mycheck#sidtest\",\"fn\":\"My Check\",\"avatar\":\"\"},{\"friend\":\"myre#sidtest\",\"fn\":\"myre\",\"avatar\":\"\"},{\"friend\":\"replicate#sidtest\",\"fn\":\"Replicates\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/AlpNsgEqeTkNQBjK.jpg\"},{\"friend\":\"restassured#sidtest\",\"fn\":\"Rest assume\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/KmVus5ljAbhWOlnb.jpg\"},{\"friend\":\"wereu#sidtest\",\"fn\":\"Wereu\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/Yasfw6PZqxOH9uOH.jpg\"},{\"friend\":\"wtgdear#sidtest\",\"fn\":\"Wtg Dear\",\"avatar\":\"\"},{\"friend\":\"checkme#anitest\",\"fn\":\"CHeckMe\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/XUl30I7JjTf5lnHe.jpg\"},{\"friend\":\"dallas#keka_moma\",\"fn\":\"Dallas\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/5DD3C754-3C0E-4A8D-B3EC-472F8BAC23C7-411-0000004E62F62B94keka_moma.jpg\"},{\"friend\":\"restreal#niteshpandav\",\"fn\":\"Rest Real\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/lD7AuXjv6thD3RIB.jpg\"},{\"friend\":\"shivani#anitest\",\"fn\":\"Shivani\",\"avatar\":\"https://s3.amazonaws.com/s3-imxam-development/AC192629-4C9C-40FD-9201-C981A4148E29-1013-00000117C7770456anitest.jpg\"},{\"friend\":\"test#niteshpandav\",\"fn\":\"MyCircle\",\"avatar\":\"\"},{\"friend\":\"vb#anitest\",\"fn\":\"Vb\",\"avatar\":\"\"}],\"user\":\"sidtest\",\"code\":0,\"id\":\"a23bf2\"}";
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
    private String TAG = Main2Activity.class.getSimpleName();
    int TOTAL = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        actionBar = getSupportActionBar();
        String string = "This is well";
        string = string.toLowerCase().replaceAll("\\s+", "").trim();
        Log.d(TAG, "String is :" + string);
        actionBar.setTitle(string);
        String check = "{\"type\":\"get_page_comments\",\"userprofile\":\"anitest\",\"size\":\"" + TOTAL + "\",\"id\":\"OszP7c\"}";
        String newcheck = check.replace("\"" + TOTAL + "\"", String.valueOf(TOTAL));
        Log.d(TAG, "NEwcheck is :" + newcheck);
        listView = (ListView) findViewById(R.id.listView);
        expanded_image = (ImageView) findViewById(R.id.expanded_image);
        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);
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
        View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        // Note that system bars will only be "visible" if none of the
                        // LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags are set.
                        if ((visibility & View.SYSTEM_UI_FLAG_LOW_PROFILE) == 0) {
                            // TODO: The system bars are visible. Make any desired
                            actionBar.show();
                        } else {
                            // TODO: The system bars are NOT visible. Make any desired
                            actionBar.hide();
                        }
                    }
                });

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contact c = (contact) parent.getItemAtPosition(position);
                String picURL = c.photoUri;
                if (!TextUtils.isEmpty(picURL)) {
                    String fname = "image_" + picURL.substring(picURL.lastIndexOf("/") != -1 ? picURL.lastIndexOf("/") + 1 : 0) + ".jpg";
                    Intent intent = new Intent(Main2Activity.this, PicasoVsUil.class);
                    intent.putExtra("Url", picURL);
                    intent.putExtra("local", fname);
                    startActivity(intent);
                }
            }
        });
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
//        final Dialog dialog = new Dialog(this, R.style.DialogTheme);
//        if (Build.VERSION.SDK_INT < 16) {
//        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
//        } else {
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//        }
//        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//        View view = View.inflate(this, R.layout.full_screen, null);
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        dialog.setContentView(view, params);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog1) {
//            }
//        });
        hideStatusBar();
        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }
        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView = (ImageView) findViewById(R.id.expanded_image);
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
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
//            PropertyValuesHolder pchX = PropertyValuesHolder.ofFloat(View.X, startBounds.left, finalBounds.left);
//            PropertyValuesHolder pchY = PropertyValuesHolder.ofFloat(View.Y, startBounds.top, finalBounds.top);
//            PropertyValuesHolder pchScaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, startScale, 1f);
//            PropertyValuesHolder pchScaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, startScale, 1f);
//            ObjectAnimator.ofPropertyValuesHolder(expandedImageView, pchX, pchY, pchScaleX, pchScaleY).start();
//        }
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
//                        dialog.dismiss();
                        showStatuBar();
                        mCurrentAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
//                        dialog.dismiss();
                        mCurrentAnimator = null;
                    }
                });
                set.start();
                mCurrentAnimator = set;
            }
        });
    }

    public void hideStatusBar() {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;// View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    public void showStatuBar() {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}
