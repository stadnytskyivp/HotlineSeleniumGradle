package com.hotline.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverFacade {
    private final WebDriver baseDriver;

    WebDriverFacade(WebDriverFactory webDriverFactory) {
        this.baseDriver = webDriverFactory.getDriver();
    }

    public WebDriver getBaseDriver(){
        return baseDriver;
    }

    public void navigateTo(String url) {
        getBaseDriver().get(url);
    }
}
