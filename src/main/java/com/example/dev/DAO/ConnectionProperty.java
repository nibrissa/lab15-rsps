package com.example.dev.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionProperty {
    public static final String CONFIG_NAME = "config.properties";
    public static final Properties PROPERTY_COFIG = new Properties();
    public ConnectionProperty() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream st = classLoader.getResourceAsStream(CONFIG_NAME);
        PROPERTY_COFIG.load(st);
    }
    public static String getProperty(String property) {
        return PROPERTY_COFIG.getProperty(property);
    }
}