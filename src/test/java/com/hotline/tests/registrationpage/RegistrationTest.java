package com.hotline.tests.registrationpage;

import com.hotline.helpers.ReusableMethods;
import com.hotline.pageobject.pages.RegistrationPage;
import com.hotline.tests.BaseTest;
import com.hotline.user.User;
import com.hotline.user.UserInfo;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Description("Verify that we see all elements of the registration page")
    @Test
    public void checkRegistrationElementsPresenceTest() {
        Allure.step("Start test checking registration elements presence");
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        Assert.assertTrue(registrationPage.getHeaderLogoLink().isDisplayed(), "expecting to see header logo image");
        Assert.assertTrue(registrationPage.getLoginField().isDisplayed(), "expecting to see login field");
        Assert.assertTrue(registrationPage.getPasswordField().isDisplayed(), "expecting to see password field");
        Assert.assertTrue(registrationPage.getNameField().isDisplayed(), "expecting to see name field");
        Assert.assertTrue(registrationPage.getShowPasswordBtn().isDisplayed(), "expecting to see show password button");
        Assert.assertTrue(registrationPage.getRegisterBtn().isDisplayed(), "expecting to see registration button");
    }

    @Description("Verify that we can register user with valid data")
    @Test(dataProvider = "validUsers")
    public void registerValidUser(User user) {
        Allure.step("Start test registration user with valid parameters");
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        registrationPage.getLoginField().sendKeys(user.getLogin());
        registrationPage.getNameField().sendKeys(user.getName());
        registrationPage.getPasswordField().sendKeys(user.getPassword());
        registrationPage.getShowPasswordBtn().click();
        registrationPage.getRegisterBtn().click();

        Assert.assertTrue(registrationPage.gotoRegistrationFinalPage().isCodeFieldEnabled(),
            "expecting to see final registration page with enabled code confirmation field");
    }

    @DataProvider
    public Object[][] validUsers() {
        return new Object[][]{
            {UserInfo.newUser()},
            {UserInfo.newUser().setName("Петро" + ReusableMethods.getRandomNumber())},
            {UserInfo.newUser().setName(ReusableMethods.getRandomNumber())},
            {UserInfo.newUser().setName(ReusableMethods.getRandomUsername() + "_-" + ReusableMethods.getRandomNumber())},
            {UserInfo.newUser().setName(ReusableMethods.getRandomUsername() + " " + ReusableMethods.getRandomNumber())},
            {UserInfo.newUser().setName("123456789012345678901234567890_over_30_symbols")},
            {UserInfo.newUser().setPassword("1234567890123456_over_16_sybols")},
            {UserInfo.newUser().setPassword("Петро" + ReusableMethods.getRandomUsername())},
            {UserInfo.newUser().setLogin(ReusableMethods.getRandomPhoneNumber())},
            {UserInfo.newUser().setLogin(" " + UserInfo.newUser().getName() + "@gmail.com")},
            {UserInfo.newUser()},
        };
    }
}
