package ru.sfedu.transportmanagementsystem.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static ru.sfedu.transportmanagementsystem.Constants.ENV_PROP_KEY;
import static ru.sfedu.transportmanagementsystem.Constants.ENV_PROP_VALUE;

public class ConfigUtil {
    private static final String DEFAULT_CONFIG_PATH = System.getProperty(ENV_PROP_KEY, ENV_PROP_VALUE);
    private static final Properties config = new Properties();


    public ConfigUtil() {
    }

    private static Properties getConfiguration() throws IOException {
        if (config.isEmpty()) {
            loadConfiguration();
        }
        return config;
    }

    private static void loadConfiguration() throws IOException {
        File nf = new File(DEFAULT_CONFIG_PATH);
        InputStream in = new FileInputStream(nf);// DEFAULT_CONFIG_PATH.getClass().getResourceAsStream(DEFAULT_CONFIG_PATH);
        try {
            config.load(in);
        } catch (IOException ex) {
            throw new IOException(ex);
        } finally {
            in.close();
        }
    }

    /*
    Keys:
      @param key Entry key
      @return Entry value by key
      @throws IOException In case of the configuration file read failure
    */

    public static String getConfigurationEntry(String key) throws IOException {
        return getConfiguration().getProperty(key);
    }

}

