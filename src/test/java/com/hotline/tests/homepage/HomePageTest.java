package com.hotline.tests.homepage;

import com.hotline.pageobject.pages.HomePage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Description("Verify that we see all elements of the home page")
    @Test
    public void checkHeaderElementsPresenceTest() {
        Allure.step("Start test checking header elements presence");
        HomePage homePage = openBrowser()
            .gotoHomePage();

        Assert.assertTrue(homePage.getLogoLink().isDisplayed(), "expecting to see top left logo image");
        Assert.assertTrue(homePage.getCityNameLink().isDisplayed(), "expecting to see city name link");
        Assert.assertTrue(homePage.getCompareItemsLink().isDisplayed(), "expecting to see compare items link");
        Assert.assertTrue(homePage.getItemCartLink().isDisplayed(), "expecting to see shopping cart link");
        Assert.assertTrue(homePage.getLoginUserLink().isDisplayed(), "expecting to see login user link");
        Assert.assertTrue(homePage.getWishListLink().isDisplayed(), "expecting to see wish list link");
        Assert.assertTrue(homePage.getChooseLanguageUkr().isDisplayed(), "expecting to see choose language");
        Assert.assertTrue(homePage.getSearchTopButton().isDisplayed(), "expecting to see top search button");
        Assert.assertTrue(homePage.getSearchTopField().isDisplayed(), "expecting to see top search field");
        Assert.assertTrue(homePage.getProductCatalog().isDisplayed(), "expecting to see product catalog");
    }
}
