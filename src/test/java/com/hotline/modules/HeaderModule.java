package com.hotline.modules;

import org.openqa.selenium.By;
import com.hotline.elements.Element;

public class HeaderModule {
    private Element logoLink = new Element(By.cssSelector(".header-logo"));
    private Element cityNameLink = new Element(By.cssSelector(".city-name"));
    //    private Element chooseLanguage = new Element();
    private Element loginUserLink = new Element(By.cssSelector(".item-login"));
    private Element compareItemsLink = new Element(By.cssSelector(".item-compare"));
    private Element wishListLink = new Element(By.cssSelector(".item-wishlist"));
    private Element itemCartLink = new Element(By.cssSelector(".item-cart"));

    public Element getLogoLink() {
        return logoLink;
    }

    public Element getCityNameLink() {
        return cityNameLink;
    }

    public Element getLoginUserLink() {
        return loginUserLink;
    }

    public Element getCompareItemsLink() {
        return compareItemsLink;
    }

    public Element getWishListLink() {
        return wishListLink;
    }

    public Element getItemCartLink() {
        return itemCartLink;
    }
}
