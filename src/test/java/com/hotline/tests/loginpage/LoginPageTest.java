package com.hotline.tests.loginpage;

import com.hotline.pageobject.pages.LoginPage;
import com.hotline.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void checkLoginElementsPresenceTest() {
        LoginPage loginPage = openBrowser()
            .gotoLoginPage();

        Assert.assertTrue(loginPage
            .getHeaderLogoLink()
            .isDisplayed());

        Assert.assertTrue(loginPage
            .getLoginField()
            .isDisplayed());

        Assert.assertTrue(loginPage
            .getPasswordField()
            .isDisplayed());

        Assert.assertTrue(loginPage
            .getSubmitBtn()
            .isDisplayed());

        Assert.assertTrue(loginPage
            .getForgotPasswordLink()
            .isDisplayed());

        Assert.assertTrue(loginPage
            .getRegisterLink()
            .isDisplayed());
    }
}
