package com.hotline.helpers;

import com.hotline.pages.HomePage;
import com.hotline.webdriver.WebDriverFacadeProvider;
import com.hotline.webdriver.WebDriverFactory;

public class HotlineNavigation {
    protected WebDriverFacadeProvider webDriverFacadeProvider = new WebDriverFacadeProvider(new WebDriverFactory());

    public HomePage toHomePage(String url) {
        webDriverFacadeProvider.get().navigateTo(url);
        return new HomePage();
    }

    public void toLoginPage() {

    }


}
