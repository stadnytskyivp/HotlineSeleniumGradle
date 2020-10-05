package com.hotline.tests.homepage;

import com.hotline.helpers.HotlineConstants;
import com.hotline.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.hotline.pages.*;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    static WebDriver driver;

    @BeforeSuite
    protected void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(HotlineConstants.BASE_URL);
    }

    @Test
    public void checkHeaderElementsPresenceTest() {
        HomePage startPage = new HomePage(driver);

    }

    @AfterSuite
    protected void closeBrowser() {
        driver.close();
    }
}