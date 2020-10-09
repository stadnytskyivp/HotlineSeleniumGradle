package com.hotline.tests.registrationpage;

import com.hotline.pageobject.pages.RegistrationPage;
import com.hotline.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Test
    public void registrationTest() {
        RegistrationPage registrationPage = openBrowser()
            .gotoLoginPage()
            .gotoRegistrationPage();

        Assert.assertTrue(registrationPage
            .getHeaderLogoLink()
            .isDisplayed());

        Assert.assertTrue(registrationPage
            .getLoginField()
            .isDisplayed());

        Assert.assertTrue(registrationPage
            .getPasswordField()
            .isDisplayed());

        Assert.assertTrue(registrationPage
            .getNameField()
            .isDisplayed());

        Assert.assertTrue(registrationPage
            .getShowPasswordBtn()
            .isDisplayed());

        Assert.assertTrue(registrationPage
            .getRegisterBtn()
            .isDisplayed());
    }
}
