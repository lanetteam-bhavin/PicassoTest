package com.example.lcom53.picassotest;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author ParthS
 * @since 29/12/15.
 */
public class MyImageLoaderListner{//} implements ImageLoadingListener {
//    String TAG = MyImageLoaderListner.class.getSimpleName();
//    ImageView imageView;
//
//    public MyImageLoaderListner(RecyclingImageView imgUserPic) {
//        imageView = imgUserPic;
//    }
//
//    @Override
//    public void onLoadingStarted(String s, View view) {
//        Log.d(TAG, "Started :" + s + "::" + System.currentTimeMillis());
//    }
//
//    @Override
//    public void onLoadingFailed(String s, View view, FailReason
//            failReason) {
//
//    }
//
//    @Override
//    public void onLoadingComplete(String s, View view, Bitmap bitmap) {
//        Log.d(TAG, "Completed :" + s + "::" + System.currentTimeMillis());
//        Log.d(TAG, "Downloaded Bitmap is:" + bitmap.getHeight() + ":" + bitmap.getWidth() + ":" + s);
////                                    String UserName = (String) view.getTag(R.string.app_name);
//        if (s != null) {
//            String fname = "image_" + s.substring(s.lastIndexOf("/") != -1 ? s.lastIndexOf("/") + 1 : 0) + ".jpg";
//            File file = new File(customCacheDirectory, fname);
//            try {
//                if (file.exists()) file.delete();
//                FileOutputStream out = new FileOutputStream(file);
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
//                out.flush();
//                out.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            Log.d(TAG, "File saved as:" + file.getAbsolutePath());
//        }
//    }
//
//    @Override
//    public void onLoadingCancelled(String s, View view) {
//
//    }

}
