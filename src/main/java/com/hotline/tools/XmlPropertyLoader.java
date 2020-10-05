package com.hotline.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class XmlPropertyLoader {
    private final static String PROPERTIES_FILE = "/config.xml";
    private final static String ENV_PREFIX = "/env-";
    private final Properties propsFromResource;

    public XmlPropertyLoader() {
        propsFromResource = loadPropsFromResource(PROPERTIES_FILE);
    }

    public String getProperty(String key) {
        return propsFromResource.getProperty(key);
    }

    private Properties loadPropsFromResource(String propertyFile) {
        Properties props = new Properties();
        try {
            final InputStream inputStream1, inputStream2;
            inputStream1 = XmlPropertyLoader.class.getResourceAsStream(propertyFile);
            props.loadFromXML(inputStream1);

            String environmentFile = ENV_PREFIX + props.getProperty("environment") + ".xml";
            inputStream2 = XmlPropertyLoader.class.getResourceAsStream(environmentFile);
            props.loadFromXML(inputStream2);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load config xml.\n" + e.getMessage());
        }

        return props;
    }
}
