package com.hotline.pageobject.pages;

import com.hotline.pageobject.modules.HeaderModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends HeaderModule {
    private List<WebElement> productNames;
    private List<WebElement> productPrices;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductNames() {
        productNames = driver.findElements(By.cssSelector(".cell-8.cell-md.text a"));
        return productNames;
    }

    public List<WebElement> getProductPrices() {
        productPrices = driver.findElements(By.cssSelector(".viewbox.viewbox-striped .value"));
        return productPrices;
    }
}
