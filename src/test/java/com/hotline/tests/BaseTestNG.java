package com.hotline.tests;

import com.hotline.helpers.HotlineNavigation;

public class BaseTestNG extends AbstractTestNG{
    protected HotlineNavigation navigate() {
        return new HotlineNavigation();
    }
}
