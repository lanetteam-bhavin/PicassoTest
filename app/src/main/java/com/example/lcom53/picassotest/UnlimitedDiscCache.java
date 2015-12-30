package com.example.lcom53.picassotest;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.utils.IoUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ParthS
 * @since 29/12/15.
 */
public class UnlimitedDiscCache implements DiskCache {

    public UnlimitedDiscCache(File cacheDir) {
    }

    @Override
    public File getDirectory() {
        return null;
    }

    @Override
    public File get(String s) {
        return null;
    }

    @Override
    public boolean save(String s, InputStream inputStream, IoUtils.CopyListener copyListener) throws IOException {
        return false;
    }

    @Override
    public boolean save(String s, Bitmap bitmap) throws IOException {
        return false;
    }

    @Override
    public boolean remove(String s) {
        return false;
    }

    @Override
    public void close() {

    }

    @Override
    public void clear() {

    }
}
