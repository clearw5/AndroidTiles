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
        if (!isScreenLockAdminActive(context)) {
            gotoDeviceManager(context);
        } else {
            lockByDeviceManagerInner(context);
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
        ComponentName componentName = new ComponentName(context, ScreenLockReceiver.class);
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "锁屏");
        context.startActivity(intent);
    }


}
