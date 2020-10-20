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
        registrationPage.getRegisterBtn().click();

        List<WebElement> actualErrors = registrationPage.getAllErrors();
        ReusableMethods.compareErrors(actualErrors, expectedErrors);
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
        registrationPage.getRegisterBtn().click();

        RegistrationFinalPage registrationFinalPage = registrationPage.gotoRegistrationFinalPage();
        registrationPage = registrationFinalPage.gotoHomePage().gotoLoginPage().gotoRegistrationPage();

        registrationPage.getLoginField().sendKeys(user.getLogin().toUpperCase());
        registrationPage.getNameField().sendKeys(user.getName());
        registrationPage.getPasswordField().sendKeys(user.getPassword());
        registrationPage.getRegisterBtn().click();

        List<WebElement> actualErrors = registrationPage.getAllErrors();
        ReusableMethods.compareErrors(actualErrors, Arrays.asList(EMAIL_OR_PHONE_ALREADY_TAKEN, NICKNAME_TAKEN));
    }

    @DataProvider
    public Object[][] invalidUsers() {
        return new Object[][]{
            //setting user with 3 invalid parameters at the same time
            {UserInfo.newUser().setLogin("khg").setName("").setPassword("123"),
                Arrays.asList(TYPE_EMAIL_OR_PHONE, EMPTY_FIELD, PASSWORD_IS_TO_SHORT)},
            //setting user with symbols in name field
            {UserInfo.newUser().setName("!@#$%^&"), Collections.singletonList(WRONG_DATA_FORMAT)},
            //setting user with empty password field
            {UserInfo.newUser().setPassword(""), Collections.singletonList(EMPTY_FIELD)},
            //setting user with symbols in password field
            {UserInfo.newUser().setPassword("!@#$%^&"), Collections.singletonList(WRONG_DATA_FORMAT)},    //expecting test fail
            //setting user with 4 symbols were 4th symbol is empty space in password field
            {UserInfo.newUser().setPassword("123 "), Collections.singletonList(PASSWORD_IS_TO_SHORT)},
            //setting user with 4 symbols were one of symbols in the middle is empty space in password field
            {UserInfo.newUser().setPassword("12 3"), Collections.singletonList(WRONG_DATA_FORMAT)},   //expecting test fail
            //setting user with empty login field
            {UserInfo.newUser().setLogin(""), Collections.singletonList(EMPTY_FIELD)},
            //setting user with cyrillic symbols in login field
            {UserInfo.newUser().setLogin("Петро" + ReusableMethods.getRandomNumber() + "@gmail.com"),
                Collections.singletonList(WRONG_DATA_FORMAT)},
            //setting user with some random name symbols in login field (not email or phone#)
            {UserInfo.newUser().setLogin(ReusableMethods.getRandomUsername()), Collections.singletonList(TYPE_EMAIL_OR_PHONE)},
            //setting user with random email with empty space before '@' symbol in login field
            {UserInfo.newUser().setLogin(UserInfo.newUser().getName() + " @gmail.com"),
                Collections.singletonList(WRONG_DATA_FORMAT)},
            //setting user with random email with empty space in the middle of email prefix in login field
            {UserInfo.newUser().setLogin(UserInfo.newUser().getName() + " " + UserInfo.newUser().getName() + "@gmail.com"),
                Collections.singletonList(TYPE_EMAIL_OR_PHONE)},    //expecting test fail
            //setting user with random email with special symbols in prefix of email in login field
            {UserInfo.newUser().setLogin("!@#$%^&" + "@gmail.com"), Collections.singletonList(WRONG_DATA_FORMAT)},
            //setting user with to short phone number in login field
            {UserInfo.newUser().setLogin(ReusableMethods.getRandomPhoneNumber().substring(0, 9)), Collections.singletonList(WRONG_DATA_FORMAT)},
            //setting user with to long phone number in login field
            {UserInfo.newUser().setLogin(ReusableMethods.getRandomPhoneNumber() + "0"), Collections.singletonList(WRONG_DATA_FORMAT)},
        };
    }
}
