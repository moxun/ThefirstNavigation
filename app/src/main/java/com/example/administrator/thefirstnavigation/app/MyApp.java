package com.example.administrator.thefirstnavigation.app;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;

/**
 * Created by Administrator on 2018/12/21.
 */

public class MyApp extends Application {
    private static  MyApp sMyApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp=this;
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        CrashReport.initCrashReport(getApplicationContext(), "c8c94ccb4c", false);
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:【友盟+】 AppKey
         * 参数3:【友盟+】 Channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         */
        UMConfigure.setLogEnabled(true);
        UMConfigure.init(this, Characterl.Appkey, "moxun", UMConfigure.DEVICE_TYPE_PHONE, "1fe6a20054bcef865eeb0991ee84525b");
    }
    public static MyApp getMyApp(){
        return sMyApp;
    }
}
