package com.hotline.pageobject.modules;

import com.hotline.pageobject.pages.HomePage;
import com.hotline.pageobject.pages.LoginPage;
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
       initElements();
    }

    private void initElements() {
        logoLink = driver.findElement(By.cssSelector(".header-logo"));
        cityNameLink = driver.findElement(By.cssSelector(".city-name"));
        chooseLanguage = driver.findElement(By.xpath("//*[@data-language='uk'][1]"));
        loginUserLink = driver.findElement(By.cssSelector(".item-login"));
        compareItemsLink = driver.findElement(By.cssSelector(".item-compare"));
        wishListLink = driver.findElement(By.cssSelector(".item-wishlist"));
        itemCartLink = driver.findElement(By.cssSelector(".item-cart"));
        searchTopButton = driver.findElement(By.id("doSearch"));
        searchTopField = driver.findElement(By.id("searchbox"));
        productCatalog = driver.findElement(By.cssSelector(".uppercase"));
    }

    public WebElement getLogoLink() {
        return logoLink;
    }

    public WebElement getCityNameLink() {
        return cityNameLink;
    }

    public WebElement getLoginUserLink() {
        return loginUserLink;
    }

    public WebElement getCompareItemsLink() {
        return compareItemsLink;
    }

    public WebElement getWishListLink() {
        return wishListLink;
    }

    public WebElement getItemCartLink() {
        return itemCartLink;
    }

    public void clickLogo() {
        getLogoLink().click();
    }

    public HomePage gotoHomePage() {
        clickLogo();
        return new HomePage(driver);
    }

    public WebElement getChooseLanguage() {
        return chooseLanguage;
    }

    public WebElement getSearchTopButton() {
        return searchTopButton;
    }

    public WebElement getSearchTopField() {
        return searchTopField;
    }

    public WebElement getProductCatalog() {
        return productCatalog;
    }

    public void clickLogin() {
        getLoginUserLink().click();
    }

    public LoginPage gotoLoginPage() {
        clickLogin();
        return new LoginPage(driver);
    }
}
