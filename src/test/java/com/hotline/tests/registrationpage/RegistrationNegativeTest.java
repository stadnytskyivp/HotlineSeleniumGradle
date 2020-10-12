package com.hotline.tests.registrationpage;

import com.hotline.pageobject.pages.RegistrationPage;
import com.hotline.tests.BaseTest;
import com.hotline.user.User;
import com.hotline.user.UserInfo;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationNegativeTest extends BaseTest {
    @Description("Verify that we can't register user with invalid credentials")
    @Test(dataProvider = "invalidUsers")
    public void registerInvalidUser(User user) {
        Allure.step("Start test registration user with invalid credentials");
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        registrationPage
            .getLoginField()
            .sendKeys(user.getLogin());

        registrationPage
            .getNameField()
            .sendKeys(user.getName());

        registrationPage.getPasswordField().sendKeys(user.getPassword());
        registrationPage.getShowPasswordBtn().click();

        registrationPage.getRegisterBtn().click();

        Assert.assertTrue(registrationPage.gotoRegistrationFinalPage().isCodeFieldEnabled(),
            "expecting to see final registration page with enabled code confirmation field");
    }

    @DataProvider
    public Object[][] invalidUsers() {
        return new Object[][]{
            {UserInfo.newUser().setLogin("")},
            {UserInfo.newUser().setPassword("")},
            {UserInfo.newUser().setName("")},
        };
    }
}
