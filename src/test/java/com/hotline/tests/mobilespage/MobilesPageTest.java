package com.hotline.tests.mobilespage;

import com.hotline.pageobject.pages.MobilesPage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobilesPageTest extends BaseTest {
    @Description("Verify that all category navigation elements on mobile page are working")
    @Test
    public void MobileCategoryNavigationTest() {
        Allure.step("Start test checking category navigation elements ");
        MobilesPage mobilePage = openBrowser()
            .gotoHomePage()
            .gotoMobilePage();

        mobilePage.getCategories().get(0).click();
        Assert.assertTrue(isVisibleInViewport(mobilePage.getCategorySmartphones()));
        mobilePage.getCategories().get(1).click();
        Assert.assertTrue(isVisibleInViewport(mobilePage.getCategoryWatchesBands()));
        mobilePage.getCategories().get(2).click();
        Assert.assertTrue(isVisibleInViewport(mobilePage.getCategoryChargers()));
        mobilePage.getCategories().get(3).click();
        Assert.assertTrue(isVisibleInViewport(mobilePage.getCategoryAccessories()));
        mobilePage.getCategories().get(4).click();
        Assert.assertTrue(isVisibleInViewport(mobilePage.getCategoryComponentsForPhones()));
    }

}
