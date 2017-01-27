package com.stardust.quicksetting.screencapture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;

/**
 * Created by Stardust on 2017/1/19.
 */

public class ScreenCapturePermissionActivity extends Activity {


    private static final int SCREEN_CAPTURE = 7777;

    public void onCreate(Bundle whatever) {
        super.onCreate(whatever);
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), SCREEN_CAPTURE);
    }

    public void onActivityResult(int requestCode, int result, Intent data) {
        if (requestCode == SCREEN_CAPTURE && result == RESULT_OK && data != null) {
            MediaProjectionScreenCaptureService.mResultData = data;
            Intent intent = new Intent(this, MediaProjectionScreenCaptureService.class);
            intent.putExtras(getIntent());
            startService(intent);
            finish();
        }
    }

}
