package com.hotline.pageobject.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class FilterModule extends HeaderModule {
    private WebElement displayDiagonal;
    private WebElement ram4;
    private WebElement rom256;
    private WebElement year2019;
    private WebElement maxPriceField;
    private WebElement priseBtnOK;

    public FilterModule(WebDriver driver) {
        super(driver);
    }

    public WebElement getDisplayDiagonal() {
        displayDiagonal = driver.findElement(By.cssSelector("a[data-eventlabel='6,01-6,39[586796]']"));
        return displayDiagonal;
    }

    public WebElement getRam4() {
        ram4 = driver.findElement(By.cssSelector("a[data-eventlabel='4[116179]']"));
        return ram4;
    }

    public WebElement getRom256() {
        rom256 = driver.findElement(By.cssSelector("a[data-eventlabel='256[388895]']"));
        return rom256;
    }

    public WebElement getYear2019() {
        year2019 = driver.findElement(By.cssSelector("a[data-eventlabel='2019[602898]']"));
        return year2019;
    }

    public WebElement getMaxPriceField() {
        maxPriceField = driver.findElement(By.cssSelector("[data-price-max]"));
        return maxPriceField;
    }

    public WebElement getPriseBtnOK() {
        priseBtnOK = driver.findElement(By.cssSelector(".nowrap.m_b-lg .btn-graphite"));
        return priseBtnOK;
    }

    public void setMaxPriceField(String maxPrice) {
        getMaxPriceField().clear();
        getMaxPriceField().sendKeys(maxPrice);
    }
}
