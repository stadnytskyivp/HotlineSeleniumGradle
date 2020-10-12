package com.hotline.tests.registrationpage;

import com.hotline.helpers.ReusableMethods;
import com.hotline.pageobject.pages.RegistrationPage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Formatter;

public class RegistrationTest extends BaseTest {
    @Description("Verify that we see all elements of the registration page")
    @Test
    public void checkRegistrationElementsPresenceTest() {
        Allure.step("Start test checking registration elements presence");
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        Assert.assertTrue(registrationPage.getHeaderLogoLink().isDisplayed(),"expecting to see header logo image");
        Assert.assertTrue(registrationPage.getLoginField().isDisplayed(), "expecting to see login field");
        Assert.assertTrue(registrationPage.getPasswordField().isDisplayed(), "expecting to see password field");
        Assert.assertTrue(registrationPage.getNameField().isDisplayed(), "expecting to see name field");
        Assert.assertTrue(registrationPage.getShowPasswordBtn().isDisplayed(), "expecting to see show password button");
        Assert.assertTrue(registrationPage.getRegisterBtn().isDisplayed(), "expecting to see registration button");
    }

    @Description("Verify that we can register user with valid data")
    @Test
    public void registerValidUser() {
        Allure.step("Start test registration user with valid parameters");
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        registrationPage
            .getLoginField()
            .sendKeys(String.valueOf(new Formatter().format("%s@gmail.com", ReusableMethods.getRandomUsername())));

        registrationPage
            .getNameField()
            .sendKeys(String.valueOf(new Formatter().format("Vova_%s", ReusableMethods.getRandomUsername())));

        registrationPage.getPasswordField().sendKeys("13245678");
        registrationPage.getShowPasswordBtn().click();
        testWaits(2);

        registrationPage.getRegisterBtn().click();
        testWaits(3);

        Assert.assertTrue(registrationPage.gotoRegistrationFinalPage().isCodeFieldEnabled(),
            "expecting to see final registration page with enabled code confirmation field");
    }
}
