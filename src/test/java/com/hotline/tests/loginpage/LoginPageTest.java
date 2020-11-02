package com.hotline.tests.loginpage;

import com.hotline.pageobject.pages.LoginPage;
import com.hotline.tests.BaseTest;
import com.hotline.user.UserInfo;
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

    @Description("Verify that user can login with valid credentials")
    @Test
    public void loginValidUser() {
        Allure.step("Start test login user with valid credentials");
        LoginPage loginPage = openBrowser().gotoLoginPage();

        loginPage.getLoginField().sendKeys(UserInfo.myUser().getLogin());
        loginPage.getPasswordField().sendKeys(UserInfo.myUser().getPassword());
        loginPage.getSubmitBtn().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
