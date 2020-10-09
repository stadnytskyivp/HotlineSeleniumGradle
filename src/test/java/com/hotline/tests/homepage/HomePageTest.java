package com.hotline.tests.homepage;

import com.hotline.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void checkHeaderElementsPresenceTest() {
        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getLogoLink()
            .isDisplayed());

        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getCityNameLink()
            .isDisplayed());

        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getCompareItemsLink()
            .isDisplayed());

        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getItemCartLink()
            .isDisplayed());

        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getLoginUserLink()
            .isDisplayed());

        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getWishListLink()
            .isDisplayed());

        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getChooseLanguage()
            .isDisplayed());

        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getSearchTopButton()
            .isDisplayed());

        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getSearchTopField()
            .isDisplayed());

        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getProductCatalog()
            .isDisplayed());
    }
}
