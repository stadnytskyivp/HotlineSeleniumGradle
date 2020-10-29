package com.hotline.tests.mobilespage;

import com.hotline.helpers.ReusableMethods;
import com.hotline.pageobject.pages.ApplePhonesPage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplePhonesPageTest extends BaseTest {
    private final static String IPHONES = "Apple iPhone";
    private final static int SORT_PRICE_RISING = 0;
    private final static int SORT_PRICE_REDUCTION = 1;
    private final static int SORT_NAME = 5;
    private final static int SORT_OFFERS = 6;
    private final static int MAX_PRICE = 27000;
    private final static String LOOK_FOR_DISPLAY = "екран: ";

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

    @Description("Verify that all selected filters are working")
    @Test
    public void checkFiltersTest() {
        Allure.step("Start test checking filters");
        ApplePhonesPage applePhonesPage = openBrowser()
            .gotoHomePage()
            .gotoMobilePage()
            .gotoApplePhonesPage();

        applePhonesPage.getChooseLanguageUkr().click();
        Assert.assertTrue(applePhonesPage.getDisplayDiagonal().isDisplayed());
        scrollTo(applePhonesPage.getDisplayDiagonal());
        Assert.assertTrue(isVisibleInViewport(applePhonesPage.getDisplayDiagonal()));
        applePhonesPage.getDisplayDiagonal().click();

        Assert.assertTrue(applePhonesPage.getRam4().isDisplayed());
        scrollTo(applePhonesPage.getRam4());
        Assert.assertTrue(isVisibleInViewport(applePhonesPage.getRam4()));
        applePhonesPage.getRam4().click();

        Assert.assertTrue(applePhonesPage.getRom256().isDisplayed());
        scrollTo(applePhonesPage.getRom256());
        Assert.assertTrue(isVisibleInViewport(applePhonesPage.getRom256()));
        applePhonesPage.getRom256().click();

        Assert.assertTrue(applePhonesPage.getYear2019().isDisplayed());
        scrollTo(applePhonesPage.getYear2019());
        Assert.assertTrue(isVisibleInViewport(applePhonesPage.getYear2019()));
        applePhonesPage.getYear2019().click();

        Assert.assertTrue(applePhonesPage.getMaxPriceField().isDisplayed());
        scrollTo(applePhonesPage.getMaxPriceField());
        Assert.assertTrue(isVisibleInViewport(applePhonesPage.getMaxPriceField()));
        applePhonesPage.setMaxPriceField(String.valueOf(MAX_PRICE));
        applePhonesPage.getPriseBtnOK().click();

        getDriver().navigate().refresh();

        ReusableMethods.areElementsInBetween(getDescriptionPart(
            applePhonesPage.getPhoneDescriptionList(), LOOK_FOR_DISPLAY, 4), 6.01, 6.39);

        ReusableMethods.areElementsLessEqualThan(getDigitsFromString(applePhonesPage.getPhonePriceList()), MAX_PRICE);
    }
}
