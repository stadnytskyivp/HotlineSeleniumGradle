package com.hotline.tests.mobilespage;

import com.hotline.helpers.ReusableMethods;
import com.hotline.pageobject.pages.ApplePhonesPage;
import com.hotline.pageobject.pages.ProductPage;
import com.hotline.pageobject.pages.ShoppingCartPage;
import com.hotline.tests.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductInShoppingCartTest extends BaseTest {
    private static final int FIRST_ITEM = 0;

    @Description("Verify that information about phone on the about the phone page is the same as in the shopping cart")
    @Test
    public void checkPhoneBrandNamesTest() {
        Allure.step("Start test adding phone to the cart and checking is data correct");
        ApplePhonesPage applePhonesPage = openBrowser()
            .gotoHomePage()
            .gotoMobilePage()
            .gotoApplePhonesPage()
            .selectSortBuyOnHotline();

        String expectedName = ReusableMethods.getProductName(applePhonesPage.getPhoneNameList().get(FIRST_ITEM).getText());
        ProductPage productPage = applePhonesPage.selectProduct(FIRST_ITEM);
        Assert.assertTrue(productPage.getProductName().getText().contains(expectedName));
        String expectedPrice = productPage.getBuyPrice().getText();
        ShoppingCartPage shoppingCartPage = productPage.clickBuyNowButton();
        Assert.assertTrue(shoppingCartPage.getProductNames().get(FIRST_ITEM).getText().contains(expectedName));
        Assert.assertEquals(shoppingCartPage.getProductPrices().get(FIRST_ITEM).getText(), expectedPrice);
    }
}
