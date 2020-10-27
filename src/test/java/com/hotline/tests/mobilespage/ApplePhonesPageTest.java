package com.hotline.tests.mobilespage;

import com.hotline.pageobject.pages.ApplePhonesPage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplePhonesPageTest extends BaseTest {
    private final static String IPHONES = "Apple iPhone";
    private final static int SORT_PRICE_RISING = 0;
    private final static int SORT_PRICE_REDUCTION = 1;
    private final static int SORT_NAME = 5;
    private final static int SORT_OFFERS = 6;

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
        applePhonesPage.getMainSortBoxItem(SORT_PRICE_RISING).click();
        Assert.assertEquals(applePhonesPage.getPhonePriceList(), sortElementsByRising(applePhonesPage.getPhonePriceList()));
    }

    @Description("Verify that all devices are sorted by the reducing price")
    @Test
    public void sortPhonesByReducingPriceTest() {
        Allure.step("Start test checking devices sorting by the reducing price");
        ApplePhonesPage applePhonesPage = openBrowser()
            .gotoHomePage()
            .gotoMobilePage()
            .gotoApplePhonesPage();

        applePhonesPage.getMainSort().click();
        applePhonesPage.getMainSortBoxItem(SORT_PRICE_REDUCTION).click();
        Assert.assertEquals(applePhonesPage.getPhonePriceList(), sortElementsByReducing(applePhonesPage.getPhonePriceList()));
    }

    @Description("Verify that all devices are sorted by name")
    @Test
    public void sortPhonesByNameTest() {
        Allure.step("Start test checking devices sorting by name");
        ApplePhonesPage applePhonesPage = openBrowser()
            .gotoHomePage()
            .gotoMobilePage()
            .gotoApplePhonesPage();

        applePhonesPage.getMainSort().click();
        applePhonesPage.getMainSortBoxItem(SORT_NAME).click();
        Assert.assertEquals(applePhonesPage.getPhoneNameList(), sortElementsByRising(applePhonesPage.getPhoneNameList()));
    }

    @Description("Verify that all devices are sorted by offers")
    @Test
    public void sortPhonesByOffersTest() {
        Allure.step("Start test checking devices sorting by offers");
        ApplePhonesPage applePhonesPage = openBrowser()
            .gotoHomePage()
            .gotoMobilePage()
            .gotoApplePhonesPage();

        applePhonesPage.getMainSort().click();
        applePhonesPage.getMainSortBoxItem(SORT_OFFERS).click();
        Assert.assertEquals(getDigitsFromString(applePhonesPage.getPhoneOfferList()),
            sortIntegers(getDigitsFromString(applePhonesPage.getPhoneOfferList())));
    }
}
