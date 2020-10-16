package com.hotline.tests.registrationpage;

import com.hotline.helpers.EErrors;
import com.hotline.helpers.ReusableMethods;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.hotline.helpers.EErrors.*;

public class RegistrationNegativeTest extends BaseTest {
    @Description("Verify that we can't register user with invalid credentials")
    @Parameters({"User register; List<EErrors> expectedErrors"})
    @Test(dataProvider = "invalidUsers")
    public void registerInvalidUser(User user, List<EErrors> expectedErrors) {
        Allure.step("Start test registration user with invalid credentials");
        RegistrationPage registrationPage = openBrowser().gotoLoginPage().gotoRegistrationPage();

        registrationPage.getLoginField().sendKeys(user.getLogin());
        registrationPage.getNameField().sendKeys(user.getName());
        registrationPage.getPasswordField().sendKeys(user.getPassword());
        registrationPage.getShowPasswordBtn().click();
        registrationPage.getRegisterBtn().click();

        List<WebElement> actualErrors = registrationPage.getAllErrors();

        if (actualErrors.size() == expectedErrors.size()) {
            ReusableMethods.compareErrors(actualErrors.size(), actualErrors, expectedErrors);
        } else Assert.assertFalse(registrationPage.isErrorVisible(),
            "expecting to see registration page without red error message near input fields");
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

        List<WebElement> actualErrors = registrationPage.getAllErrors();

        if (actualErrors.size() == 2) {
            ReusableMethods.compareErrors(actualErrors.size(), actualErrors,
                Arrays.asList(EMAIL_OR_PHONE_ALREADY_TAKEN, NICKNAME_TAKEN));
        } else {
            Assert.assertFalse(registrationPage.isErrorVisible(),
                "expecting to see registration page without red error message near input fields");
        }
    }

    @DataProvider
    public Object[][] invalidUsers() {
        return new Object[][]{
            {UserInfo.newUser().setLogin("khg").setName("").setPassword("123"),
                Arrays.asList(TYPE_EMAIL_OR_PHONE, EMPTY_FIELD, PASSWORD_IS_TO_SHORT)},
            {UserInfo.newUser().setLogin("").setPassword("123"), Arrays.asList(EMPTY_FIELD, PASSWORD_IS_TO_SHORT)},
            {UserInfo.newUser().setName(""), Collections.singletonList(EMPTY_FIELD)},
            {UserInfo.newUser().setName(UserInfo.newUser().getName() + "@abc"), Collections.singletonList(WRONG_DATA_FORMAT)},
            {UserInfo.newUser().setName("!@#$%^&"), Collections.singletonList(WRONG_DATA_FORMAT)},
            {UserInfo.newUser().setPassword(""), Collections.singletonList(EMPTY_FIELD)},
            {UserInfo.newUser().setPassword("!@#$%^&"), Collections.singletonList(WRONG_DATA_FORMAT)},    //expecting fail
            {UserInfo.newUser().setPassword("123"), Collections.singletonList(PASSWORD_IS_TO_SHORT)},
            {UserInfo.newUser().setPassword("123 "), Collections.singletonList(PASSWORD_IS_TO_SHORT)},
            {UserInfo.newUser().setPassword("12 3"), Collections.singletonList(WRONG_DATA_FORMAT)},   //expecting fail
            {UserInfo.newUser().setLogin(""), Collections.singletonList(EMPTY_FIELD)},
            {UserInfo.newUser().setLogin("Петро" + ReusableMethods.getRandomNumber() + "@gmail.com"),
                Collections.singletonList(WRONG_DATA_FORMAT)},
            {UserInfo.newUser().setLogin(ReusableMethods.getRandomUsername()), Collections.singletonList(TYPE_EMAIL_OR_PHONE)},
            {UserInfo.newUser().setLogin(UserInfo.newUser().getName() + " @gmail.com"),
                Collections.singletonList(WRONG_DATA_FORMAT)},
            {UserInfo.newUser().setLogin(UserInfo.newUser().getName() + " " + UserInfo.newUser().getName() + "@gmail.com"),
                Collections.singletonList(TYPE_EMAIL_OR_PHONE)},    //expecting fail
            {UserInfo.newUser().setLogin("!@#$%^&" + "@gmail.com"), Collections.singletonList(WRONG_DATA_FORMAT)},
        };
    }
}
