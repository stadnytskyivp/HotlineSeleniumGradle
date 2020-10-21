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
        headerLogoLink = driver.findElement(By.cssSelector(".header-short"));
        codeField = driver.findElement(By.xpath("//*[@type='code']"));
    }

    public WebElement getCodeField() {
        return codeField;
    }

    public boolean isCodeFieldEnabled() {
        return getCodeField().isEnabled();
    }

    public WebElement getHeaderLogoLink() {
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
