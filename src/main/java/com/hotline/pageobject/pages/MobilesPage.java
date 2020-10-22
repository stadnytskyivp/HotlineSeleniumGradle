package com.hotline.pageobject.pages;

import com.hotline.pageobject.modules.HeaderModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobilesPage extends HeaderModule {
    private WebElement headerTitle;
    private List<WebElement> categories;
    private WebElement categorySmartphones;
    private WebElement categoryWatchesBands;
    private WebElement categoryChargers;
    private WebElement categoryAccessories;
    private WebElement categoryComponentsForPhones;

    MobilesPage(WebDriver driver) {
        super(driver);
        headerTitle = driver.findElement(By.xpath("//h1/i[@class='icon-menu icon-menu-mobile']"));
        categories = driver.findElements(By.cssSelector(".category-navigation-item"));
        categorySmartphones = driver.findElement(
                By.xpath("//h2[@data-scroll-smooth-to-element-to='telefony-i-garnitury']"));
        categoryWatchesBands = driver.findElement(
                By.xpath("//h2[@data-scroll-smooth-to-element-to='smart-chasy-i-fitnes-braslety']"));
        categoryChargers = driver.findElement(
                By.xpath("//h2[@data-scroll-smooth-to-element-to='zaryadka-i-sinhronizaciya']"));
        categoryAccessories = driver.findElement(
                By.xpath("//h2[@data-scroll-smooth-to-element-to='dopolnitelnoe-oborudovanie-i-aksessuary']"));
        categoryComponentsForPhones = driver.findElement(
                By.xpath("//h2[@data-scroll-smooth-to-element-to='komplektuyuschie-dlya-telefonov-i-smartfonov']"));
    }

    public WebElement getHeaderTitle() {
        return headerTitle;
    }

    public List<WebElement> getCategories() {
        return categories;
    }

    public WebElement getCategoryComponentsForPhones() {
        return categoryComponentsForPhones;
    }

    public WebElement getCategorySmartphones() {
        return categorySmartphones;
    }

    public WebElement getCategoryWatchesBands() {
        return categoryWatchesBands;
    }

    public WebElement getCategoryChargers() {
        return categoryChargers;
    }

    public WebElement getCategoryAccessories() {
        return categoryAccessories;
    }
}
