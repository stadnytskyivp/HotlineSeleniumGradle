package com.hotline.pageobject.pages;

import com.hotline.pageobject.modules.HeaderModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends HeaderModule {
    private WebElement mobileCatalog;

    public HomePage(WebDriver driver) {
        super(driver);
        mobileCatalog = driver.findElement(By.cssSelector(".icon-menu-mobile"));
    }

    public WebElement getMobileCatalog() {
        return mobileCatalog;
    }

    public MobilesPage gotoMobilePage() {
        clickMobileCategory();
        return new MobilesPage(driver);
    }

    private HomePage clickMobileCategory() {
        getMobileCatalog().click();
        return this;
    }
}
