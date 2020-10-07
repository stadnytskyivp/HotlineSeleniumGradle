package com.hotline.helpers;

import com.hotline.pages.HomePage;
import com.hotline.webdriver.WebDriverFacadeProvider;
import com.hotline.webdriver.WebDriverFactory;

public class HotlineNavigation {
    private WebDriverFacadeProvider webDriverFacadeProvider;

    public WebDriverFacadeProvider getWebDriverFacadeProvider() {
        if (webDriverFacadeProvider == null) {
            return new WebDriverFacadeProvider(new WebDriverFactory());
        } else {
            return webDriverFacadeProvider;
        }
    }

    public HomePage toHomePage(String url) {
        getWebDriverFacadeProvider().get().navigateTo(url);
        return new HomePage();
    }

    public void toLoginPage() {

    }


}
