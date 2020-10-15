package com.hotline.tests.registrationpage;

import com.beust.jcommander.Parameter;
import com.hotline.helpers.ReusableMethods;
import com.hotline.pageobject.pages.RegistrationFinalPage;
import com.hotline.pageobject.pages.RegistrationPage;
import com.hotline.tests.BaseTest;
import com.hotline.user.User;
import com.hotline.user.UserInfo;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationNegativeTest extends BaseTest {
    @Description("Verify that we can't register user with invalid credentials")
    @Parameters({"User register"})
    @Test(dataProvider = "invalidUsers")
    public void registerInvalidUser(User user) {
        Allure.step("Start test registration user with invalid credentials");
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        registrationPage.getLoginField().sendKeys(user.getLogin());
        registrationPage.getNameField().sendKeys(user.getName());
        registrationPage.getPasswordField().sendKeys(user.getPassword());
        registrationPage.getShowPasswordBtn().click();
        registrationPage.getRegisterBtn().click();

        Assert.assertTrue(registrationPage.isErrorVisible(),
            "expecting to see registration page with red error message near input fields");
    }

    @Description("Verify that we can't register existing user")
    @Test
    public void registerExistingUser() {
        Allure.step("Start test registration existing user");
        User user = UserInfo.newUser();
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        registrationPage.getLoginField().sendKeys(user.getLogin());
        registrationPage.getNameField().sendKeys(user.getName());
        registrationPage.getPasswordField().sendKeys(user.getPassword());
        registrationPage.getShowPasswordBtn().click();
        registrationPage.getRegisterBtn().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registrationPage.gotoRegistrationFinalPage();
        // not working at the moment

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        registrationPage.gotoHomePage().gotoLoginPage().gotoRegistrationPage();
        registrationPage.getLoginField().sendKeys(user.getLogin());
        registrationPage.getNameField().sendKeys(user.getName());
        registrationPage.getPasswordField().sendKeys(user.getPassword());
        registrationPage.getShowPasswordBtn().click();
        registrationPage.getRegisterBtn().click();

        Assert.assertTrue(registrationPage.isErrorVisible(),
            "expecting to see registration page with red error message near input fields");
    }

    @DataProvider
    public Object[][] invalidUsers() {
        return new Object[][]{
            {UserInfo.newUser().setName("")},
            {UserInfo.newUser().setName(UserInfo.newUser().getName() + "@abc")},
            {UserInfo.newUser().setName("!@#$%^&")},
            {UserInfo.newUser().setPassword("")},
            {UserInfo.newUser().setPassword("!@#$%^&")},    //expecting fail
            {UserInfo.newUser().setPassword("123")},
            {UserInfo.newUser().setPassword("123 ")},
            {UserInfo.newUser().setPassword("12 3")},   //expecting fail
            {UserInfo.newUser().setLogin("")},
            {UserInfo.newUser().setLogin("Петро" + ReusableMethods.getRandomNumber() + "@gmail.com")},
            {UserInfo.newUser().setLogin(ReusableMethods.getRandomUsername())},
            {UserInfo.newUser().setLogin(UserInfo.newUser().getName() + " @gmail.com")},
            {UserInfo.newUser().setLogin(UserInfo.newUser().getName() + " " + UserInfo.newUser().getName() + " @gmail.com")},
            {UserInfo.newUser().setLogin("!@#$%^&" + "@gmail.com")},
        };
    }
}
