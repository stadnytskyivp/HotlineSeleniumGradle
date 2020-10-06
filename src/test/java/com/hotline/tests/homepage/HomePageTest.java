package com.hotline.tests.homepage;

import com.hotline.helpers.HotlineConstants;
import com.hotline.modules.HeaderModule;
import com.hotline.tests.BaseTestNG;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTestNG {

    @Test
    public void checkHeaderElementsPresenceTest() {
        HeaderModule headerModule = navigate()
            .toHomePage(HotlineConstants.BASE_URL)
            .getHeaderModule();
        logAssert(assertThat(headerModule.getLogoLink().isDisplayed()));
    }

//    @AfterSuite
//    protected void closeBrowser() {
//        driver.close();
//    }
}