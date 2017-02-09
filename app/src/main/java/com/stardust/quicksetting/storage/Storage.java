package com.stardust.quicksetting.storage;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/**
 * Created by Stardust on 2017/2/6.
 */

public class Storage {


    public static void checkStoragePermission(Context context) {
        if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            context.startActivity(new Intent(context, StoragePermissionActivity.class));
        }
    }
}
