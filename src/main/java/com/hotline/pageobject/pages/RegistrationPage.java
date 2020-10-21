package com.hotline.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage extends AuthorizationPage {
    private WebElement nameField;
    private WebElement registerBtn;
    private WebElement showPasswordBtn;
    private WebElement errorMsg;

    public RegistrationPage (WebDriver driver) {
        super(driver);
        nameField = driver.findElement(By.name("name"));
        registerBtn = driver.findElement(By.id("submit-button"));
        showPasswordBtn = driver.findElement(By.cssSelector(".check-view"));
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }

    public WebElement getShowPasswordBtn() {
        return showPasswordBtn;
    }

    public RegistrationFinalPage gotoRegistrationFinalPage() {
        return new RegistrationFinalPage(driver);
    }

    public WebElement getErrorMsg() {
        return driver.findElement(By.cssSelector(".errors"));
    }

    public boolean isErrorVisible() {
        return getErrorMsg().isDisplayed();
    }

    public String getErrorText() {
        return getErrorMsg().getText();
    }

    public List<WebElement> getAllErrors() {
        return driver.findElements(By.cssSelector(".errors"));
    }
}
