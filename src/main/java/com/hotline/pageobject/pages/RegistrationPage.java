package com.hotline.pageobject.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        errorMsg = driver.findElement(By.cssSelector(".errors"));
        return errorMsg;
    }

    public boolean isErrorVisible() {
        return getErrorMsg().isDisplayed();
    }

    public RegistrationPage closeAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
//        driver.switchTo().confirmationAlertalert().dismiss();
        return this;
    }
}