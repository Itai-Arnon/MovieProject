package com.itai.mymoviesappbylistviewsinglefrag.utils;


import android.app.Application;
import android.content.Context;
import android.util.Log;

public class MyApp extends Application implements Thread.UncaughtExceptionHandler {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();


        Thread.setDefaultUncaughtExceptionHandler(this);
    }


    public static Context getContext() {
        return context;

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.e("MyApp", "Catch exception " + e.getMessage());
        // will revive the activity
         startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
    }
}
