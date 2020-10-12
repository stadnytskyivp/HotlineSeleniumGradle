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
        initElements();
    }

    private void initElements() {
        submitBtn = driver.findElement(By.xpath("//*[@data-id='verification']"));
        forgotPasswordLink = driver.findElement(By.xpath("//*[@href='/reminder/']"));
        registerLink = driver.findElement(By.xpath("//*[@href='/register/']"));
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getRegisterLink() {
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
