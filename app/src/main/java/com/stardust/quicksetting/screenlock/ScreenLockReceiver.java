package com.stardust.quicksetting.screenlock;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Stardust on 2017/1/20.
 */

public class ScreenLockReceiver extends DeviceAdminReceiver {

    private static final String TAG = "ScreenLockReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.v(TAG, "onReceive");
    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        Log.v(TAG, "onEnabled");
        super.onEnabled(context, intent);
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        Log.v(TAG, "onDisabled");
        super.onDisabled(context, intent);
    }
}
