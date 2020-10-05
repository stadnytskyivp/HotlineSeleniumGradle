package com.hotline.elements;

import org.openqa.selenium.By;

public class Element {
    private final By by;
    private boolean waitBeforeUse;

    public Element(By by) {
        this(by, true);
    }

    public Element(By by, boolean waitBeforeUse) {
        this.by = by;
        this.waitBeforeUse = waitBeforeUse;
    }
}
