package com.stardust.quicksetting.tool;

import android.os.Environment;

import java.lang.reflect.Field;

/**
 * Created by Stardust on 2017/1/20.
 */

public class Config {

    public static final String DEFAULT_FOLDER = Environment.getExternalStorageDirectory() + "/截图/";
    public static final String DEFAULT_CONFIG_PATH = DEFAULT_FOLDER + "config.txt";
    public static final String DEFAULT_METHOD = "MediaProjection";
    public static final String DEFAULT_DELAY = "998";

    public static String path = DEFAULT_FOLDER, method = DEFAULT_METHOD, delay = DEFAULT_DELAY;

    static {
        new ConfigReader().setConfigExecutor(new ConfigReader.ConfigExecutor() {
            @Override
            public void apply(String name, String value) {
                try {
                    Field field = Config.class.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(null, value);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }).readAndApplyAll();
    }


}
