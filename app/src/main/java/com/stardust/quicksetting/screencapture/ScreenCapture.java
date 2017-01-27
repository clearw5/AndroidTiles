package com.stardust.quicksetting.screencapture;

import android.content.Context;
import android.content.Intent;

import com.stardust.quicksetting.tool.Config;
import com.stardust.quicksetting.tool.Shell;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static com.stardust.quicksetting.tool.Config.DEFAULT_FOLDER;

/**
 * Created by Stardust on 2017/1/20.
 */

public abstract class ScreenCapture {

    public static void captureByConfigMethod(Context context) {
        if (Config.method != null && Config.method.equals(Screencap.NAME)) {
            new Screencap(context).capture();
        } else {
            new MediaProjectionScreenCapture(context).capture();
        }
    }

    private final Context mContext;

    public ScreenCapture(Context context) {
        mContext = context;
    }


    public void capture() {
        String path = getSaveFolderPath();
        collapseNotificationBar(mContext);
        ensureFolder(path);
        capture(mContext, path + generateFileName());
    }

    private String getSaveFolderPath() {
        String path = Config.path;
        if (path == null || path.isEmpty()) {
            path = DEFAULT_FOLDER;
        }
        return path;
    }

    private void collapseNotificationBar(Context context) {
        Intent it = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        context.sendBroadcast(it);
    }

    private void ensureFolder(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    private String generateFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss", Locale.getDefault());
        return "Screenshot_" + simpleDateFormat.format(new Date()) + System.currentTimeMillis() % 1000 + ".png";

    }

    protected abstract void capture(Context context, String path);

    public static class Screencap extends ScreenCapture {

        private static final String NAME = "screencap";


        public Screencap(Context context) {
            super(context);
        }

        @Override
        protected void capture(Context context, final String path) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Shell.execCommand("screencap -p " + path, true);
                }
            }, Long.parseLong(Config.delay));
        }
    }

    public static class MediaProjectionScreenCapture extends ScreenCapture {

        public static final String NAME = "media";

        public MediaProjectionScreenCapture(Context context) {
            super(context);
        }

        @Override
        protected void capture(Context context, String path) {
            Intent intent = new Intent(context, ScreenCapturePermissionActivity.class);
            intent.putExtra("path", path);
            intent.putExtra("delay", Long.parseLong(Config.delay));
            context.startActivity(intent);
        }
    }


}
