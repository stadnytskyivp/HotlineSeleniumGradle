package com.hotline.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XmlDataLoader {
    private final static String PROPERTIES_FILE = System.getProperty("user.dir") + "/src/main/resources/config.xml";

    public static String getProperty(String user) {
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(user);
    }
}
