package com.hotline.pageobject.modules;

import com.hotline.pageobject.pages.HomePage;
import com.hotline.pageobject.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class HeaderModule {
    protected WebDriver driver;

    private WebElement logoLink;
    private WebElement cityNameLink;
    private WebElement chooseLanguage;
    private WebElement loginUserLink;
    private WebElement compareItemsLink;
    private WebElement wishListLink;
    private WebElement itemCartLink;
    private WebElement searchTopButton;
    private WebElement searchTopField;
    private WebElement productCatalog;

    public HeaderModule(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogoLink() {
        logoLink = driver.findElement(By.cssSelector(".header-logo"));
        return logoLink;
    }

    public WebElement getCityNameLink() {
        cityNameLink = driver.findElement(By.cssSelector(".city-name"));
        return cityNameLink;
    }

    public WebElement getLoginUserLink() {
        loginUserLink = driver.findElement(By.cssSelector(".item-login"));
        return loginUserLink;
    }

    public WebElement getCompareItemsLink() {
        compareItemsLink = driver.findElement(By.cssSelector(".item-compare"));
        return compareItemsLink;
    }

    public WebElement getWishListLink() {
        wishListLink = driver.findElement(By.cssSelector(".item-wishlist"));
        return wishListLink;
    }

    public WebElement getItemCartLink() {
        itemCartLink = driver.findElement(By.cssSelector(".item-cart"));
        return itemCartLink;
    }

    public void clickLogo() {
        getLogoLink().click();
    }

    @Step("Going to the home page")
    public HomePage gotoHomePage() {
        clickLogo();
        return new HomePage(driver);
    }

    public WebElement getChooseLanguage() {
        chooseLanguage = driver.findElement(By.xpath("//*[@data-language='uk'][1]"));
        return chooseLanguage;
    }

    public WebElement getSearchTopButton() {
        searchTopButton = driver.findElement(By.id("doSearch"));
        return searchTopButton;
    }

    public WebElement getSearchTopField() {
        searchTopField = driver.findElement(By.id("searchbox"));
        return searchTopField;
    }

    public WebElement getProductCatalog() {
        productCatalog = driver.findElement(By.cssSelector(".uppercase"));
        return productCatalog;
    }

    public void clickLogin() {
        getLoginUserLink().click();
    }

    @Step("Going to the login page")
    public LoginPage gotoLoginPage() {
        clickLogin();
        return new LoginPage(driver);
    }
}
