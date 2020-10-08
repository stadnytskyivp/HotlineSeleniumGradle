package com.hotline.tests.homepage;

import com.hotline.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void checkHeaderElementsPresenceTest() {
        Assert.assertTrue(openBrowser()
            .gotoHomePage()
            .getLogoLink()
            .isDisplayed());
    }
}
