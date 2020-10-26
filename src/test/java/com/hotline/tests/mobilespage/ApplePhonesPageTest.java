package com.hotline.tests.mobilespage;

import com.hotline.pageobject.pages.ApplePhonesPage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplePhonesPageTest extends BaseTest {
    private final static String IPHONES = "Apple iPhone";
    private final static int PRICE_RISING = 0;
    private final static int PRICE_REDUCTION = 1;

    @Description("Verify that all devices in the list have required brand name")
    @Test
    public void checkPhoneBrandNamesTest() {
        Allure.step("Start test checking devices brand names");
        ApplePhonesPage applePhonesPage = openBrowser()
                .gotoHomePage()
                .gotoMobilePage()
                .gotoApplePhonesPage();

        checkElementsContent(applePhonesPage.getPhoneNameList(), IPHONES);
    }

    @Description("Verify that all devices are sorted by the rising price")
    @Test
    public void sortPhonesByRisingPriceTest() {
        Allure.step("Start test checking devices sorting by the rising price");
        ApplePhonesPage applePhonesPage = openBrowser()
                .gotoHomePage()
                .gotoMobilePage()
                .gotoApplePhonesPage();

        applePhonesPage.getMainSort().click();
        applePhonesPage.getMainSortBoxItem(PRICE_RISING).click();

        Assert.assertEquals(applePhonesPage.getPhonePriceList(), sortElementList(applePhonesPage.getPhonePriceList()));
    }
}
