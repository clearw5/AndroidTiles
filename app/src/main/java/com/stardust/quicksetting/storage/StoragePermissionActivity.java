package com.stardust.quicksetting.storage;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Stardust on 2017/2/6.
 */

public class StoragePermissionActivity extends Activity {

    private static final int REQUEST_CODE = 7777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        finish();
    }
}
