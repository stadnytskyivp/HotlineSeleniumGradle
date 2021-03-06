package com.hotline.pageobject.pages;

import com.hotline.pageobject.modules.FilterModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApplePhonesPage extends FilterModule {
    private List<WebElement> phoneNameList;
    private WebElement mainSort;
    private WebElement mainSortBox;
    private List<WebElement> phonePriceList;
    private List<WebElement> phoneOfferList;
    private List<WebElement> phoneDescriptionList;

    ApplePhonesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getPhoneNameList() {
        phoneNameList = driver.findElements(By. cssSelector("[data-tracking-id=catalog-10]"));
        return phoneNameList;
    }

    public WebElement getMainSort() {
        mainSort = driver.findElement(By.cssSelector("[name=sort]"));
        return mainSort;
    }

    public WebElement getMainSortBoxItem(int number) {
        mainSortBox = driver.findElement(By.cssSelector(String.format(("[name='sort'] [data-value='%s']"), number)));
        return mainSortBox;
    }

    public List<WebElement> getPhonePriceList() {
        phonePriceList = driver.findElements(By.cssSelector(".item-price span.value"));
        return phonePriceList;
    }

    public List<WebElement> getPhoneOfferList() {
        phoneOfferList = driver.findElements(By.cssSelector("[data-tracking-id=catalog-12]"));
        return phoneOfferList;
    }

    public List<WebElement> getPhoneDescriptionList() {
        phoneDescriptionList = driver.findElements(By.cssSelector(".item-info .text .text p"));
        return phoneDescriptionList;
    }
}
