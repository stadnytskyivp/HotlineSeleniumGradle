package com.hotline.pageobject.pages;

import com.hotline.pageobject.modules.HeaderModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobilesPage extends HeaderModule {
    private List<WebElement> categories;
    private WebElement categorySmartphones;
    private WebElement categoryWatchesBands;
    private WebElement categoryChargers;
    private WebElement categoryAccessories;
    private WebElement categoryComponentsForPhones;
    private WebElement applePhonesLink;

    MobilesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCategories() {
        categories = driver.findElements(By.cssSelector(".category-navigation-item"));
        return categories;
    }

    public WebElement getCategoryComponentsForPhones() {
        categoryComponentsForPhones = driver.findElement(
            By.cssSelector("[data-scroll-smooth-to-element-to='komplektuyuschie-dlya-telefonov-i-smartfonov']"));
        return categoryComponentsForPhones;
    }

    public WebElement getCategorySmartphones() {
        categorySmartphones = driver.findElement(
            By.cssSelector("[data-scroll-smooth-to-element-to='telefony-i-garnitury']"));
        return categorySmartphones;
    }

    public WebElement getCategoryWatchesBands() {
        categoryWatchesBands = driver.findElement(
            By.cssSelector("[data-scroll-smooth-to-element-to='smart-chasy-i-fitnes-braslety']"));
        return categoryWatchesBands;
    }

    public WebElement getCategoryChargers() {
        categoryChargers = driver.findElement(
            By.cssSelector("[data-scroll-smooth-to-element-to='zaryadka-i-sinhronizaciya']"));
        return categoryChargers;
    }

    public WebElement getCategoryAccessories() {
        categoryAccessories = driver.findElement(
            By.cssSelector("[data-scroll-smooth-to-element-to='dopolnitelnoe-oborudovanie-i-aksessuary']"));
        return categoryAccessories;
    }

    public WebElement getApplePhonesLink() {
        applePhonesLink = driver.findElement(By.cssSelector("[href='/mobile/mobilnye-telefony-i-smartfony/294245/']"));
        return applePhonesLink;
    }

    public ApplePhonesPage gotoApplePhonesPage() {
        getApplePhonesLink().click();
        return new ApplePhonesPage(driver);
    }
}
