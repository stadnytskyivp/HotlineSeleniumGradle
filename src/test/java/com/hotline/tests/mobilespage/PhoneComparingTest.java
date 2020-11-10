package com.hotline.tests.mobilespage;

import com.hotline.helpers.ReusableMethods;
import com.hotline.pageobject.pages.ApplePhonesPage;
import com.hotline.pageobject.pages.ComparePage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PhoneComparingTest extends BaseTest {
    private final int THREE_PHONES = 3;

    @Description("Verify that information about phones equals to the information on the compare page")
    @Test
    public void checkPhoneBrandNamesTest() {
        Allure.step("Start test adding phones to the compare list and checking is data correct");
        ApplePhonesPage applePhonesPage = openBrowser()
            .gotoHomePage()
            .gotoMobilePage()
            .gotoApplePhonesPage();

        ReusableMethods.clickOnElements(applePhonesPage.getCompareCheckboxes(), THREE_PHONES);
        List<String> expectedNames = ReusableMethods.getProductName(applePhonesPage.getPhoneNameList(), THREE_PHONES);
        ComparePage comparePage = applePhonesPage.gotoComparePage();
        List<String> actualNames = ReusableMethods.getProductName(comparePage.getProductNames(), THREE_PHONES);
        Assert.assertEquals(actualNames, expectedNames);
    }
}
