package com.hotline.tests.loginpage;

import com.hotline.pageobject.pages.LoginPage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Description("Verify that we see all elements of login page")
    @Test
    public void checkLoginElementsPresenceTest() {
        Allure.step("Start test checking login elements presence");
        LoginPage loginPage = openBrowser()
            .gotoLoginPage();

        Assert.assertTrue(loginPage.getHeaderLogoLink().isDisplayed(), "expecting to see header logo image");
        Assert.assertTrue(loginPage.getLoginField().isDisplayed(), "expecting to see login field");
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed(), "expecting to see password field");
        Assert.assertTrue(loginPage.getSubmitBtn().isDisplayed(), "expecting to see submit button");
        Assert.assertTrue(loginPage.getForgotPasswordLink().isDisplayed(), "expecting to see forgot password link");
        Assert.assertTrue(loginPage.getRegisterLink().isDisplayed(), "expecting to see register link");
    }
}
