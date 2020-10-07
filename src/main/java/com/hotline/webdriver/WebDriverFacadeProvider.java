package com.hotline.webdriver;

public class WebDriverFacadeProvider {
    private final ThreadLocal<WebDriverFacade> drivers = new InheritableThreadLocal<>();
    private final WebDriverFactory webDriverFactory;

    public WebDriverFacadeProvider(WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }

    public WebDriverFacade get() {
        if (drivers.get() == null) {
            drivers.set(new WebDriverFacade(webDriverFactory));
        }
        return drivers.get();
    }

    public void kill() {
        try {
            drivers.get().quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            drivers.remove();
        }
    }
}
