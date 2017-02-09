package com.stardust.quicksetting.screenlock;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.stardust.quicksetting.tool.Shell;

/**
 * Created by Stardust on 2017/1/20.
 */

public class ScreenLock {

    public static void lockByShell() {
        Shell.execCommand("input keyevent 26", true);
    }

    public static void lockByDeviceManager(Context context) {
        lockByDeviceManagerInner(context);
        if (!isScreenLockAdminActive(context)) {
            gotoDeviceManager(context);
        }
    }

    private static void lockByDeviceManagerInner(Context context) {
        DevicePolicyManager policyManager = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        policyManager.lockNow();
    }

    private static boolean isScreenLockAdminActive(Context context) {
        DevicePolicyManager policyManager = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName componentName = new ComponentName(context, ScreenLockReceiver.class);
        return policyManager.isAdminActive(componentName);
    }

    private static void gotoDeviceManager(Context context) {
        context.startActivity(new Intent(context, ScreenLockAdminActivateActivity.class));
    }


}
