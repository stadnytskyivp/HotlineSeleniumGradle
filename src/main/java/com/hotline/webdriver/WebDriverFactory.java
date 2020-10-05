package com.hotline.webdriver;

import com.hotline.tools.CurrentEnv;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;

public class WebDriverFactory {
    private CurrentEnv currentEnv;
    private MutableCapabilities capabilities;

    WebDriverFactory() {
        setupWebDriver();
    }

    private void setupWebDriver() {
        switch (currentEnv.getBrowserType()) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                break;
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                break;
            }
            case EDGE: {
                WebDriverManager.edgedriver().setup();
                break;
            }
            default: {
                throw new RuntimeException("Wrong driver type: " + currentEnv.getBrowserType().getName());
            }
        }
    }
}
