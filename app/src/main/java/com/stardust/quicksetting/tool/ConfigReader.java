package com.stardust.quicksetting.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Stardust on 2017/1/20.
 */

public class ConfigReader {


    interface ConfigExecutor {

        void apply(String name, String value);
    }

    private static final String DEFAULT_CONFIG_FILE_PATH = Config.DEFAULT_CONFIG_PATH;


    private ConfigExecutor mConfigExecutor;
    private File mConfigFile;

    public ConfigReader(String configFilePath) {
        mConfigFile = new File(configFilePath);
    }

    public ConfigReader() {
        this(DEFAULT_CONFIG_FILE_PATH);
    }

    public ConfigReader setConfigExecutor(ConfigExecutor executor) {
        mConfigExecutor = executor;
        return this;
    }

    public void readAndApplyAll() {
        if (!mConfigFile.exists()) {
            return;
        }
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(mConfigFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        int i = line.indexOf('=');
                        String name = line.substring(0, i);
                        String value = line.substring(i + 1);
                        applyConfig(name, value);
                    } catch (Exception ignored) {

                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void applyConfig(String name, String value) {
        if (mConfigExecutor != null) {
            mConfigExecutor.apply(name, value);
        }
    }


}
