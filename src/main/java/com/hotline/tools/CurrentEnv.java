package com.hotline.tools;

import com.hotline.webdriver.Browser;

public class CurrentEnv {
    private Browser browser;
    private XmlPropertyLoader propertyLoader;

    public Browser getBrowserType() {
        if (browser == null) {
            browser = Browser.getByName(getPropertyFromSysPropsOrFile("browser type"));
        }
        return browser;
    }

    public String getPropertyFromSysPropsOrFile(String prop) {
        String systemProperty = System.getProperty(prop);
        return systemProperty != null ? systemProperty : propertyLoader.getProperty(prop);
    }
}
