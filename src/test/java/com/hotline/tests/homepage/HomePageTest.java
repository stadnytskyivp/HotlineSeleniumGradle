package com.hotline.tests.homepage;

import com.hotline.pageobject.pages.HomePage;
import com.hotline.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void checkHeaderElementsPresenceTest() {
        HomePage homePage = openBrowser()
            .gotoHomePage();

        Assert.assertTrue(homePage
            .getLogoLink()
            .isDisplayed());

        Assert.assertTrue(homePage
            .getCityNameLink()
            .isDisplayed());

        Assert.assertTrue(homePage
            .getCompareItemsLink()
            .isDisplayed());

        Assert.assertTrue(homePage
            .getItemCartLink()
            .isDisplayed());

        Assert.assertTrue(homePage
            .getLoginUserLink()
            .isDisplayed());

        Assert.assertTrue(homePage
            .getWishListLink()
            .isDisplayed());

        Assert.assertTrue(homePage
            .getChooseLanguage()
            .isDisplayed());

        Assert.assertTrue(homePage
            .getSearchTopButton()
            .isDisplayed());

        Assert.assertTrue(homePage
            .getSearchTopField()
            .isDisplayed());

        Assert.assertTrue(homePage
            .getProductCatalog()
            .isDisplayed());
    }
}
