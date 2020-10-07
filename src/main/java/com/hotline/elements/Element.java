package com.hotline.elements;

import com.hotline.webdriver.WebDriverFacade;
import com.hotline.webdriver.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Element {
    private static final int LONG_WAIT_SECONDS = 20;
    private static final int SHORT_WAIT_SECONDS = 4;

    private final By by;
    private boolean waitBeforeUse;
    private Element parent;
    private WebElement webElement;
    private WebDriverFacade driver;

    public WebDriverFacade getDriver() {
        if (driver == null) {
            return new WebDriverFacade(new WebDriverFactory());
        } else {
            return driver;
        }
    }

    public Element(By by) {
        this(by, true);
    }

    public Element(By by, boolean waitBeforeUse) {
        this.by = by;
        this.waitBeforeUse = waitBeforeUse;
    }

    public Element(WebElement webElement) {
        this.by = null;
        this.waitBeforeUse = false;
        this.webElement = webElement;
    }

    protected boolean isDisplayed(int seconds) {
        try {
            waitUntilVisible(seconds);
            return true;
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException ignore) {
            return false;
        }
    }

    public boolean isDisplayed() {
        return isDisplayed(LONG_WAIT_SECONDS);
    }

    public WebElement getWebElement() {
        if (webElement == null) {
            if (parent == null) {
                webElement = waitBeforeUse ?
                    new WebDriverWait(getDriver().getBaseDriver(), LONG_WAIT_SECONDS).until(
                        visibilityOfElementLocated(by)) :
                    getDriver().findElement(by);
            } else {
                webElement = waitBeforeUse ?
                    new WebDriverWait(getDriver().getBaseDriver(), LONG_WAIT_SECONDS).until(
                        visibilityOf(parent.findElement(by).getWebElement())) :
                    parent.findElement(by).getWebElement();
            }
        }
        return webElement;
    }

    public Element findElement(By by) {
        return new Element(getWebElement().findElement(by));
    }

    public Element waitUntilVisible(int seconds) {
        if (parent != null) {
            webElement = new WebDriverWait(getDriver().getBaseDriver(), seconds).until(visibilityOf(
                parent.findElement(by).getWebElement()));
        } else if (by != null) {
            webElement = new WebDriverWait(getDriver().getBaseDriver(), seconds).until(visibilityOfElementLocated(by));
        }else if (webElement != null) {
            webElement = new WebDriverWait(getDriver().getBaseDriver(), seconds).until(visibilityOf(webElement));
        }
        return this;
    }
}
