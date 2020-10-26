package com.hotline.tests;

import com.hotline.pageobject.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Comparator;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class BaseTest {
    public static final String BASE_URL = "https://hotline.ua/";
    private WebDriver driver;

    protected WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
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
        getDriver().get(BASE_URL);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    public Boolean isVisibleInViewport(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver = ((RemoteWebElement) element).getWrappedDriver();
        return wait.until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "var elem = arguments[0],                 " +
                            "  box = elem.getBoundingClientRect(),    " +
                            "  cx = box.left + box.width / 2,         " +
                            "  cy = box.top + box.height / 2,         " +
                            "  e = document.elementFromPoint(cx, cy); " +
                            "for (; e; e = e.parentElement) {         " +
                            "  if (e === elem)                        " +
                            "    return true;                         " +
                            "}                                        " +
                            "return false;                            "
                    , element);
        });
    }

    protected void checkElementsContent(List<WebElement> elements, String expectedData) {
                for (WebElement i : elements) {
            Assert.assertTrue(i.getText().contains(expectedData));
        }
    }

    protected List<WebElement> sortElementList(List<WebElement> sortedlist){
        Comparator<WebElement> comparator = Comparator.comparing(WebElement::getText);
        sortedlist.sort(comparator);
        return sortedlist;
    }
}
