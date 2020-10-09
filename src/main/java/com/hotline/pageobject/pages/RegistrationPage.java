package com.hotline.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends AuthorizationPage {
    private WebElement nameField;
    private WebElement registerBtn;
    private WebElement showPasswordBtn;

    public RegistrationPage (WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
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
}
