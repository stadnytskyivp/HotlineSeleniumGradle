package com.hotline.tools;

import com.hotline.webdriver.Browser;

public class CurrentEnv {
    private Browser browser;
    private XmlPropertyLoader propertyLoader;

    public Browser getBrowserType() {
        if (browser == null) {
            browser = Browser.getByName(getPropertyFromSysPropsOrFile("browserType"));
        }
        return browser;
    }

    public String getPropertyFromSysPropsOrFile(String prop) {
        String systemProperty = System.getProperty(prop);
        return systemProperty != null ? systemProperty : propertyLoader.getProperty(prop);
    }

    public String getRunType() {
        return getPropertyFromSysPropsOrFile("runType");
    }

    public int getLongWaitSecondsTimeout() {
        return Integer.valueOf(getPropertyFromSysPropsOrFile("longWaitSeconds"));
    }
}
