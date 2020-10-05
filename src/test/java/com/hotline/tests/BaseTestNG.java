package com.hotline.tests;

import com.hotline.helpers.HotlineNavigation;

public class BaseTestNG {
    protected HotlineNavigation navigate() {
        return new HotlineNavigation();
    }
}
