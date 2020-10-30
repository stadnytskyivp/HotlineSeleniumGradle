package com.hotline.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationFinalPage {
    private WebDriver driver;

    private WebElement headerLogoLink;
    private WebElement codeField;

    public RegistrationFinalPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCodeField() {
        codeField = driver.findElement(By.cssSelector("[type='code']"));
        return codeField;
    }

    public boolean isCodeFieldEnabled() {
        return getCodeField().isEnabled();
    }

    public WebElement getHeaderLogoLink() {
        headerLogoLink = driver.findElement(By.cssSelector(".header-short"));
        return headerLogoLink;
    }

    public HomePage gotoHomePage() {
        clickLogo();
        return new HomePage(driver);
    }

    private void clickLogo() {
        getHeaderLogoLink().click();
    }
}
