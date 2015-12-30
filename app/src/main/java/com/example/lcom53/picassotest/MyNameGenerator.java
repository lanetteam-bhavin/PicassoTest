package com.example.lcom53.picassotest;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;

/**
 * @author ParthS
 * @since 29/12/15.
 */
public class MyNameGenerator implements FileNameGenerator {
    @Override
    public String generate(String s) {
        return s.substring(s.lastIndexOf("/") != -1 ? s.lastIndexOf("/") + 1 : 0) + ".jpg";
    }
}
