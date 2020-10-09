package com.hotline.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AuthorizationPage {
    protected WebDriver driver;

    private WebElement headerLogoLink;
    private WebElement loginField;
    private WebElement passwordField;

    protected AuthorizationPage (WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        headerLogoLink = driver.findElement(By.cssSelector(".header-short"));
        loginField = driver.findElement(By.name("login"));
        passwordField = driver.findElement(By.name("password"));
    }

    public WebElement getHeaderLogoLink() {
        return headerLogoLink;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public HomePage gotoHomePage() {
        clickLogo();
        return new HomePage(driver);
    }

    private void clickLogo() {
        getHeaderLogoLink().click();
    }
}
