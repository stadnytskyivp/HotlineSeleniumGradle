package com.hotline.tests.registrationpage;

import com.hotline.helpers.ReusableMethods;
import com.hotline.pageobject.pages.RegistrationPage;
import com.hotline.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Formatter;

public class RegistrationTest extends BaseTest {
    @Test
    public void registrationTest() {
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        Assert.assertTrue(registrationPage.getHeaderLogoLink().isDisplayed(),"expecting ....");
        Assert.assertTrue(registrationPage.getLoginField().isDisplayed());
        Assert.assertTrue(registrationPage.getPasswordField().isDisplayed());
        Assert.assertTrue(registrationPage.getNameField().isDisplayed());
        Assert.assertTrue(registrationPage.getShowPasswordBtn().isDisplayed());
        Assert.assertTrue(registrationPage.getRegisterBtn().isDisplayed());
    }

    @Test
    public void registerValidUser() {
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        registrationPage
            .getLoginField()
            .sendKeys(String.valueOf(new Formatter().format("%s@gmail.com", ReusableMethods.getRandomUsername())));

        registrationPage
            .getNameField()
            .sendKeys(String.valueOf(new Formatter().format("Vova_" + ReusableMethods.getRandomUsername())));

        registrationPage.getPasswordField().sendKeys("13245678");
        registrationPage.getShowPasswordBtn().click();

        // place here explicit wait for 2 sec

        registrationPage.getRegisterBtn().click();

        // place here explicit wait for 3 sec

        Assert.assertTrue(registrationPage.gotoRegistrationFinalPage().isCodeFieldEnabled());
    }
}
