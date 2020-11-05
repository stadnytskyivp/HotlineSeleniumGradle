package com.hotline.pageobject.pages;

import com.hotline.pageobject.modules.HeaderModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends HeaderModule {
    private WebElement buyButton;
    private WebElement buyPrice;
    private WebElement productName;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBuyButton() {
        buyButton = driver.findElement(By.cssSelector(".btn-blue.m_b-sm"));
        return buyButton;
    }

    public WebElement getBuyPrice() {
        buyPrice = driver.findElement(By.cssSelector("[data-resume-checkout] .value"));
        return buyPrice;
    }

    public WebElement getProductName() {
        productName = driver.findElement(By.cssSelector("[datatype='card-title']"));
        return productName;
    }

    public ShoppingCartPage gotoShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage clickBuyNowButton() {
        getBuyButton().click();
        return gotoShoppingCartPage();
    }
}
