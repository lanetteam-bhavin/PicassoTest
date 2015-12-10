package com.example.lcom53.picassotest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AlphabetIndexer;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class ContactListAdapter extends BaseAdapter implements Filterable {
    private final Activity context;
    LayoutInflater inflater;
    ArrayList<contact> data;
    private static AlphabetIndexer mIndexer;
    private ArrayList<contact> glossariesListForSearch;
    String TAG = "ContactListAdapter";
    SendFilteredDataBack sendFilteredDataBack;
    //    Picasso imageLoader;
    OkHttpClient okHttpClient = new OkHttpClient();
    String CACHE_DIR = "MyCache";
    Cache cache;
    DisplayImageOptions options;
    DisplayImageOptions options1;
    ImageLoader imageLoader = ImageLoader.getInstance();
    ImageLoaderConfiguration config;
    File customCacheDirectory;
    ViewHolder viewHolder;

    public void setImageClickListner(ImageClickListner imageClickListner) {
        this.imageClickListner = imageClickListner;
    }

    ImageClickListner imageClickListner = null;


    public interface SendFilteredDataBack {
        void sendData(ArrayList<contact> searchcontactArray, int i);
    }

    public interface ImageClickListner {
        void onImageClicked(View v, String imageUrl);
    }

    public ContactListAdapter(final Activity context, ArrayList<contact> data, SendFilteredDataBack sfd) {
        super();
        this.context = context;
        this.data = data;
        glossariesListForSearch = data;
        inflater = LayoutInflater.from(context);
        sendFilteredDataBack = sfd;
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.xml_src_image)
                .showImageForEmptyUri(R.drawable.xml_src_image)
                .showImageOnFail(R.drawable.xml_src_image)
                .cacheOnDisk(true)
                .build();
        options1 = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.xml_src_image)
                .showImageForEmptyUri(R.drawable.xml_src_image)
                .showImageOnFail(R.drawable.xml_src_image)
                .cacheOnDisk(true).imageScaleType(ImageScaleType.NONE_SAFE)
                .resetViewBeforeLoading(true)
//                .preProcessor(new BitmapProcessor() {
//                    @Override
//                    public Bitmap process(Bitmap source) {
//                        Log.d(TAG, "Pre processror:Height :" + source.getHeight() + ":" + source.getWidth());
//                        int targetWidth = context.getResources().getDimensionPixelSize(R.dimen.dim65);
//                        double aspectRatio = (double) source.getHeight() / (double) source.getWidth();
//                        int targetHeight = (int) (targetWidth * aspectRatio);
//                        Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
//                        if (result != source) {
//                            source.recycle();
//                        }
//                        return result;
//                    }
//                })
                .build();
        config = new ImageLoaderConfiguration.Builder(context).
                build();
        imageLoader.init(config);
        customCacheDirectory = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/" + CACHE_DIR);
        if (!customCacheDirectory.exists()) {
            boolean isCreated = customCacheDirectory.mkdirs();
            Log.d(TAG, "::" + customCacheDirectory.getAbsolutePath() + "isCreated:" + isCreated);
        } else {
            Log.d(TAG, "Already exists");
        }

    }

    public ArrayList<contact> getData() {
        return data;
    }

    @Override
    public int getCount() {
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public contact getItem(int position) {
        return data.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        viewHolder = new ViewHolder();
        try {
            if (view == null) {
                LayoutInflater inflator = context.getLayoutInflater();
                view = inflator.inflate(R.layout.row_contact_list_view, null);
                viewHolder.tvName = (TextView) view.findViewById(R.id.tv_contact_row_name);
                viewHolder.tvuname = (TextView) view.findViewById(R.id.tv_contact_row_user_name);
                viewHolder.imgUserPic = (RecyclingImageView) view.findViewById(R.id.iv_contact_row_user_image);
                viewHolder.sortKeyLayout = (LinearLayout) view.findViewById(R.id.sort_key_layout);
                viewHolder.sortKey = (TextView) view.findViewById(R.id.sort_key);
                viewHolder.tvBlocked = (TextView) view.findViewById(R.id.tv_blocked_status);
                viewHolder.iv_play = (ImageView) view.findViewById(R.id.iv_play);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            contact glossary = data.get(position);
//            int section = mIndexer.getSectionForPosition(position);
//            if (position == mIndexer.getPositionForSection(section) && position != 0) {
//                viewHolder.sortKey.setText(glossary.sortKey);
//                viewHolder.sortKeyLayout.setVisibility(View.VISIBLE);
//            } else {
//                viewHolder.sortKeyLayout.setVisibility(View.GONE);
//            }
            if (data.get(position).is_block == 1) {
                viewHolder.tvBlocked.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvBlocked.setVisibility(View.INVISIBLE);
            }
            viewHolder.tvName.setText(data.get(position).completename);
            viewHolder.tvuname.setText(data.get(position).username);
            String picURL = data.get(position).photoUri;
            viewHolder.imgUserPic.setTag(picURL);
            viewHolder.imgUserPic.setTag(R.string.app_name, data.get(position).username);
            viewHolder.imgUserPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (imageClickListner != null) {
                        String picUrl = (String) v.getTag();
                        Log.d(TAG, "Pic Url is:" + picUrl);
                        imageClickListner.onImageClicked(v, picUrl);
                    }
                }
            });
            if (picURL != null && !picURL.equalsIgnoreCase("") && !picURL.equals("null")) {
//                Picasso.with(context).load(picURL).centerCrop().resizeDimen(R.dimen.dim65, R.dimen.dim65).into(viewHolder.imgUserPic);
//                        new Target() {
//                    @Override
//                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
//                        Log.d(TAG, " :" + loadedFrom.name());
//                        Log.d(TAG, viewHolder.imgUserPic.getTag().toString());
//                        viewHolder.imgUserPic.setImageBitmap(bitmap);
//                    }
//
//                    @Override
//                    public void onBitmapFailed(Drawable drawable) {
//
//                    }
//
//                    @Override
//                    public void onPrepareLoad(Drawable drawable) {
//
//                    }
//                });
                String fname = "" + data.get(position).username + "_" + picURL.substring(picURL.lastIndexOf("/") != -1 ? picURL.lastIndexOf("/") + 1 : 0) + ".jpg";
                File file = new File(customCacheDirectory, fname);
                Log.d(TAG, "We pass :" + picURL);
                if (file.exists()) {
                    Log.d(TAG, "File is exists");
                    viewHolder.imgUserPic.setTag(fname);
                    imageLoader.displayImage("file://" + file.getAbsolutePath(), viewHolder.imgUserPic, options1, new ImageLoadingListener() {
                        @Override
                        public void onLoadingStarted(String s, View view) {

                        }

                        @Override
                        public void onLoadingFailed(String s, View view, FailReason failReason) {

                        }

                        @Override
                        public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                            Log.d(TAG, "Bitmap is:" + bitmap.getHeight() + ":" + bitmap.getWidth() + ":" + s);
                        }

                        @Override
                        public void onLoadingCancelled(String s, View view) {

                        }
                    });
//                    viewHolder.imgUserPic.setImageBitmap(bitmap);
//                    Picasso.with(context).load(file).placeholder(R.drawable.xml_src_image).fit().into(viewHolder.imgUserPic);
                } else {
                    imageLoader.displayImage(picURL, viewHolder.imgUserPic, options
                            , new ImageLoadingListener() {
                        @Override


                        public void onLoadingStarted(String s, View view) {

                        }

                        @Override


                        public void onLoadingFailed(String s, View view, FailReason failReason) {

                        }

                        @Override


                        public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                            Log.d(TAG, "Downloaded Bitmap is:" + bitmap.getHeight() + ":" + bitmap.getWidth() + ":" + s);
                            String UserName = (String) view.getTag(R.string.app_name);
                            if (UserName != null) {
                                String fname = "" + UserName + "_" + s.substring(s.lastIndexOf("/") != -1 ? s.lastIndexOf("/") + 1 : 0) + ".jpg";
                                if (!customCacheDirectory.exists()) {
                                    boolean created = customCacheDirectory.mkdirs();
                                    Log.d(TAG, "Created :" + created);
                                } else {
                                    Log.d(TAG, "Already exists");
                                }
                                File file = new File(customCacheDirectory, fname);
                                try {
                                    if (file.exists()) file.delete();
                                    FileOutputStream out = new FileOutputStream(file);
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                                    out.flush();
                                    out.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Log.d(TAG, "File saved as:" + file.getAbsolutePath());
                            }
                        }

                        @Override


                        public void onLoadingCancelled(String s, View view) {

                        }
                    });
                }
            } else {
                viewHolder.imgUserPic.setImageDrawable(context.getResources().getDrawable(R.drawable.xml_src_image));
            }
            if (picURL.toLowerCase().contains(".mp4") || picURL.toLowerCase().contains(".3gp")) {
                viewHolder.iv_play.setVisibility(View.VISIBLE);
            } else {
                viewHolder.iv_play.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvuname;
        ImageView iv_play;
        RecyclingImageView imgUserPic;
        LinearLayout sortKeyLayout;
        TextView sortKey;
        TextView tvBlocked;
        MyLoader imageTarget;
//		,tv_isowner;
    }

    public class MyLoader implements Target {
        ImageView imageView;
        String mPicUrl;

        public MyLoader(ImageView imageView) {
            this.imageView = imageView;
            mPicUrl = "";
            if (imageView.getTag() != null) {
                mPicUrl = imageView.getTag().toString();
            }
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            Log.d(TAG, "Picurl :" + mPicUrl);
            this.imageView.setImageBitmap(bitmap);
        }

        @Override
        public void onBitmapFailed(Drawable drawable) {

        }

        @Override
        public void onPrepareLoad(Drawable drawable) {

        }
    }

    public void setIndexer(AlphabetIndexer indexer) {
        mIndexer = indexer;
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    Filter myFilter = new Filter() {
        @SuppressWarnings("unchecked")
        @Override
        public void publishResults(CharSequence constraint, final FilterResults results) {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    data = (ArrayList<contact>) results.values;
                    if (results.count != glossariesListForSearch.size()) {
                        sendFilteredDataBack.sendData(data, 1);
                        notifyDataSetChanged();
                    } else {
                        sendFilteredDataBack.sendData(data, 0);
                        notifyDataSetInvalidated();
                    }

                }
            });
        }

        @Override
        public FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            ArrayList<contact> tempGlossaryList = new ArrayList<contact>();
            if (constraint != null && glossariesListForSearch != null) {
                int length = glossariesListForSearch.size();
                Log.i("Filtering", "glossaries size" + length);
                int i = 0;
                while (i < length) {
                    contact item = glossariesListForSearch.get(i);
                    if (item.username.toLowerCase().contains(constraint.toString().toLowerCase()) || item.completename.toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempGlossaryList.add(item);
                    }
                    i++;
                }
                filterResults.values = tempGlossaryList;
                filterResults.count = tempGlossaryList.size();
                Log.i("Filtering", "Filter result count size" + filterResults.count);
            }
            return filterResults;
        }
    };
}