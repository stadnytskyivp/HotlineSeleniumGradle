package com.hotline.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Element {
    private final By by;

    private boolean waitBeforeUse;
    private Element parent;
    private WebElement webElement;

//    public Element(WebElement webElement) {
//        this.by = null;
//        this.waitBeforeUse = false;
//        this.webElement = webElement;
//    }

    public Element(By by) {
        this(by, true);
    }

//    public Element(By by, Element parent) {
//        this(by, parent, false);
//    }

//    public Element(By by, Element parent, boolean waitBeforeUse) {
//        this.by = by;
//        this.parent = parent;
//        this.waitBeforeUse = waitBeforeUse;
//    }

    public Element(By by, boolean waitBeforeUse) {
        this.by = by;
        this.waitBeforeUse = waitBeforeUse;
    }
}
