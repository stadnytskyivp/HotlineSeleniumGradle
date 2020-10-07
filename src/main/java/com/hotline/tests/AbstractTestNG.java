package com.hotline.tests;

import com.hotline.webdriver.WebDriverFacade;
import org.assertj.core.api.AbstractAssert;
import org.testng.annotations.AfterMethod;

public abstract class AbstractTestNG {
    private WebDriverFacade webDriverFacade;

    protected <T extends AbstractAssert> T logAssert(T abstractAssert) {
        return abstractAssert;
    }

//    @AfterMethod(alwaysRun = true)
//    public void testTearDown() {
//        webDriverFacade.quit();
//    }
}
