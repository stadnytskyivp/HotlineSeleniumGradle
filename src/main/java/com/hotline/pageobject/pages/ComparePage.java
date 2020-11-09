package com.hotline.pageobject.pages;

import com.hotline.pageobject.modules.HeaderModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComparePage extends HeaderModule {
    private List<WebElement> productNames;

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductNames() {
        productNames = driver.findElements(By.cssSelector(".title-overflow"));
        return productNames;
    }
}
