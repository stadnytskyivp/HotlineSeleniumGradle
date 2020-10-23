package com.hotline.pageobject.pages;

import com.hotline.pageobject.modules.HeaderModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApplePhonesPage extends HeaderModule {
    private WebElement categoryHeader;
    private List<WebElement> iphoneList;
    private List<WebElement> phoneNameList;

    ApplePhonesPage (WebDriver driver){
        super(driver);
        categoryHeader = driver.findElement(By.xpath("//*[@class='heading']/h1"));
        iphoneList = driver.findElements(By.cssSelector(".product-item"));
        phoneNameList = driver.findElements(By.xpath("//*[@class='item-info']/p/a"));
    }

    public WebElement getCategoryHeader() {
        return categoryHeader;
    }

    public List<WebElement> getIphoneList() {
        return iphoneList;
    }

    public List<WebElement> getPhoneNameList() {
        return phoneNameList;
    }
}
