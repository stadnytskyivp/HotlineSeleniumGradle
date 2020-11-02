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
    }

    public WebElement getHeaderLogoLink() {
        headerLogoLink = driver.findElement(By.cssSelector(".header-short"));
        return headerLogoLink;
    }

    public WebElement getLoginField() {
        loginField = driver.findElement(By.name("login"));
        return loginField;
    }

    public WebElement getPasswordField() {
        passwordField = driver.findElement(By.name("password"));
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
