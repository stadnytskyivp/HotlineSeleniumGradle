package com.hotline.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverFacade {
    private final WebDriver baseDriver;

    public WebDriverFacade(WebDriverFactory webDriverFactory) {
        this.baseDriver = webDriverFactory.getDriver();
    }

    public WebDriver getBaseDriver() {
        return baseDriver;
    }

    public void navigateTo(String url) {
        getBaseDriver().get(url);
    }

    public WebElement findElement(By by) {
        return getBaseDriver().findElement(by);
    }
}
