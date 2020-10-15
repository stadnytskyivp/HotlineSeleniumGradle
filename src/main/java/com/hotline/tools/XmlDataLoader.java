package com.hotline.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XmlDataLoader {
    private final static String PROPERTIES_FILE = System.getProperty("user.dir") + "/src/main/resources/config.xml";

    public static String getProperty(String user) throws IOException {
        Properties prop = new Properties();
        prop.loadFromXML(new FileInputStream(PROPERTIES_FILE));
        return prop.getProperty(user);
    }
}