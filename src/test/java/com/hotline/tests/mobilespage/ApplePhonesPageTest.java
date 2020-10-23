package com.hotline.tests.mobilespage;

import com.hotline.pageobject.pages.ApplePhonesPage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ApplePhonesPageTest extends BaseTest {
    private final static String IPHONES = "Apple iPhone";

    @Description("Verify that all devices in the list have required brand name")
    @Test
    public void checkPhoneBrandNamesTest() {
        Allure.step("Start test checking devices brand names");
        ApplePhonesPage applePhonesPage = openBrowser()
                .gotoHomePage()
                .gotoMobilePage()
                .gotoApplePhonesPage();

        whetherElementsContain(applePhonesPage.getPhoneNameList(), IPHONES);
    }
}
