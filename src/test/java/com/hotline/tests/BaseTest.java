package com.hotline.tests;

import com.hotline.helpers.HotlineConstants;
import com.hotline.pageobject.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
        }
        return driver;
    }

    @Step("Opening browser")
    public HomePage openBrowser() {
        return new HomePage(getDriver());
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        getDriver().get(HotlineConstants.BASE_URL);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
