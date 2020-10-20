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

    @Description("Verify that show password button works on registration page")
    @Test
    public void checkShowPasswordBtnTest() {
        Allure.step("Start test checking show password button on registration page");
        User user = UserInfo.newUser();
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();
        registrationPage.getPasswordField().sendKeys(user.getPassword());
        Assert.assertNotEquals(registrationPage.getPasswordField().getText(), user.getPassword());
        registrationPage.getShowPasswordBtn().click();
        Assert.assertEquals(registrationPage.getPasswordField().getText(), user.getPassword());
        registrationPage.getShowPasswordBtn().click();
        Assert.assertNotEquals(registrationPage.getPasswordField().getText(), user.getPassword());
    }

    @DataProvider
    public Object[][] validUsers() {
        return new Object[][]{
            //setting user with expected random data
            {UserInfo.newUser()},
            //setting user with cyrillic name and random number
            {UserInfo.newUser().setName("Петро" + ReusableMethods.getRandomNumber())},
            //setting user with name made of random numbers only
            {UserInfo.newUser().setName(ReusableMethods.getRandomNumber())},
            //setting user with random name and number with symbols between
            {UserInfo.newUser().setName(ReusableMethods.getRandomUsername() + "_-" + ReusableMethods.getRandomNumber())},
            //setting user with random name and number with empty space between
            {UserInfo.newUser().setName(ReusableMethods.getRandomUsername() + " " + ReusableMethods.getRandomNumber())},
            //setting user with random name with over 30 symbols
            {UserInfo.newUser().setName(ReusableMethods.getRandomUsername() + "123456789012345678901234567890")},
            //setting user with password with over 16 symbols
            {UserInfo.newUser().setPassword("1234567890123456_over_16_sybols")},
            //setting user with cyrillic word in password and random name
            {UserInfo.newUser().setPassword("Петро" + ReusableMethods.getRandomUsername())},
            //setting user with random phone number in login field
            {UserInfo.newUser().setLogin(ReusableMethods.getRandomPhoneNumber())},
            //setting user with empty space and email login in login field
            {UserInfo.newUser().setLogin(" " + UserInfo.newUser().getName() + "@gmail.com")},
        };
    }
}
