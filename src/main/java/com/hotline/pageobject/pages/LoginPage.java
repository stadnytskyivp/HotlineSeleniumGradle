package com.hotline.pageobject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AuthorizationPage {
    private WebElement submitBtn;
    private WebElement forgotPasswordLink;
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSubmitBtn() {
        submitBtn = driver.findElement(By.xpath("//*[@data-id='verification']"));
        return submitBtn;
    }

    public WebElement getForgotPasswordLink() {
        forgotPasswordLink = driver.findElement(By.xpath("//*[@href='/reminder/']"));
        return forgotPasswordLink;
    }

    public WebElement getRegisterLink() {
        registerLink = driver.findElement(By.xpath("//*[@href='/register/']"));
        return registerLink;
    }

    @Step("Going to the registration page")
    public RegistrationPage gotoRegistrationPage() {
        clickRegister();
        return new RegistrationPage(driver);
    }

    private void clickRegister() {
        getRegisterLink().click();
    }
}
