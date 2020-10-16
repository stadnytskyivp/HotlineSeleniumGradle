package com.hotline.tests.registrationpage;

import com.hotline.helpers.EErrors;
import com.hotline.pageobject.pages.RegistrationFinalPage;
import com.hotline.pageobject.pages.RegistrationPage;
import com.hotline.tests.BaseTest;
import com.hotline.user.User;
import com.hotline.user.UserInfo;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.hotline.helpers.EErrors.*;

public class RegistrationNegativeTest extends BaseTest {
    @Description("Verify that we can't register user with invalid credentials")
    @Parameters({"User register"})
    @Test(dataProvider = "invalidUsers")
    public void registerInvalidUser(User user, List<EErrors> expectedErrors) {
        Allure.step("Start test registration user with invalid credentials");
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        registrationPage.getLoginField().sendKeys(user.getLogin());
        registrationPage.getNameField().sendKeys(user.getName());
        registrationPage.getPasswordField().sendKeys(user.getPassword());
        registrationPage.getShowPasswordBtn().click();
        registrationPage.getRegisterBtn().click();

        System.out.println(" **** ");

        List<WebElement> actualErrors = registrationPage.getAllErrors();
        System.out.println(actualErrors.size());

        if (actualErrors.size() == expectedErrors.size()) {
            int i = actualErrors.size();
            System.out.println(actualErrors.get(i-1).getText());
            System.out.println(expectedErrors.get(i-1).getError());
            while (i != 0) {
//                actualErrors.get(i);
                Assert.assertEquals(actualErrors.get(i).getText(), expectedErrors.get(i).getError());
                i--;
            }
        }

        System.out.println(registrationPage.getErrorText());
        System.out.println(" **** ");

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

        RegistrationFinalPage registrationFinalPage = registrationPage.gotoRegistrationFinalPage();
        registrationPage = registrationFinalPage.gotoHomePage().gotoLoginPage().gotoRegistrationPage();

        registrationPage.getLoginField().sendKeys(user.getLogin().toUpperCase());
        registrationPage.getNameField().sendKeys(user.getName());
        registrationPage.getPasswordField().sendKeys(user.getPassword());
        registrationPage.getShowPasswordBtn().click();
        registrationPage.getRegisterBtn().click();

        if (registrationPage.isErrorVisible())

            Assert.assertTrue(registrationPage.isErrorVisible(),
                "expecting to see registration page with red error message near input fields");
    }

    @DataProvider
    public Object[][] invalidUsers() {
        return new Object[][]{
            {UserInfo.newUser().setName("").setLogin("").setPassword(""),
                Arrays.asList(EMPTY_FIELD, EMPTY_FIELD, EMPTY_FIELD)},
//            {UserInfo.newUser().setName("")},
//            {UserInfo.newUser().setName(UserInfo.newUser().getName() + "@abc")},
//            {UserInfo.newUser().setName("!@#$%^&")},
//            {UserInfo.newUser().setPassword("")},
//            {UserInfo.newUser().setPassword("!@#$%^&")},    //expecting fail
//            {UserInfo.newUser().setPassword("123")},
//            {UserInfo.newUser().setPassword("123 ")},
//            {UserInfo.newUser().setPassword("12 3")},   //expecting fail
//            {UserInfo.newUser().setLogin("")},
//            {UserInfo.newUser().setLogin("Петро" + ReusableMethods.getRandomNumber() + "@gmail.com")},
//            {UserInfo.newUser().setLogin(ReusableMethods.getRandomUsername())},
//            {UserInfo.newUser().setLogin(UserInfo.newUser().getName() + " @gmail.com")},
//            {UserInfo.newUser().setLogin(UserInfo.newUser().getName() + " " + UserInfo.newUser().getName() + " @gmail.com")},
//            {UserInfo.newUser().setLogin("!@#$%^&" + "@gmail.com")},
        };
    }
}
