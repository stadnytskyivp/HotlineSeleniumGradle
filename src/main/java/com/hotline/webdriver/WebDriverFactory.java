package com.hotline.webdriver;

import com.hotline.tools.CurrentEnv;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private CurrentEnv currentEnv;
    private MutableCapabilities capabilities;

    public WebDriverFactory(){}
    public WebDriverFactory(CurrentEnv currentEnv) {
        this.currentEnv = currentEnv;
        if ("local".equals(currentEnv.getRunType())){
            setupWebDriver();
        }
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

    WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
