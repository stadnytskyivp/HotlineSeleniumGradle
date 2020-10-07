package com.hotline.tests;

import com.hotline.webdriver.WebDriverFacadeProvider;
import org.assertj.core.api.AbstractAssert;
import org.testng.annotations.AfterMethod;

public abstract class AbstractTestNG {
    private WebDriverFacadeProvider webDriverFacadeProvider;

    protected <T extends AbstractAssert> T logAssert(T abstractAssert) {
        return abstractAssert;
    }

//    @AfterMethod(alwaysRun = true)
//    public void testTearDown() {
//        webDriverFacadeProvider.kill();
//    }
}
