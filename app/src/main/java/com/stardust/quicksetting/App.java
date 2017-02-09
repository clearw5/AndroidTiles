package com.stardust.quicksetting;

import android.Manifest;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;

import com.stardust.quicksetting.storage.StoragePermissionActivity;

/**
 * Created by Stardust on 2017/2/6.
 */

public class App extends Application {

    private static App app;

    public static App getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

}
