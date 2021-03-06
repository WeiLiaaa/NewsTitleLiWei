package com.liwei.newstitle.application;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by wu  suo  wei on 2017/2/9.
 * 初始化Application
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化imageloader
        ImageLoaderConfiguration conf=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(conf);
        //初始化 xutils3
        x.Ext.init(this);
    }
}
