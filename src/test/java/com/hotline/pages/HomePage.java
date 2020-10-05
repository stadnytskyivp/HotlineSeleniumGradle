package com.hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage {
    private final WebDriver driver;
    private final WebElement searchEdit;
    private final WebElement searchBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.searchEdit = driver.findElement(By.name("q"));
        this.searchBtn = driver.findElement(By.name("btnK"));
    }
}
