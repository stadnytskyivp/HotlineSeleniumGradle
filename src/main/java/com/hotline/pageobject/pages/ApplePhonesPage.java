package com.hotline.pageobject.pages;

import com.hotline.pageobject.modules.HeaderModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApplePhonesPage extends HeaderModule {
    private List<WebElement> phoneNameList;
    private WebElement mainSort;
    private WebElement mainSortBox;
    private List<WebElement> phonePriceList;

    ApplePhonesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getPhoneNameList() {
        phoneNameList = driver.findElements(By.xpath("//*[@class='item-info']/p/a"));
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
}
