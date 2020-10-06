package com.hotline.tests;

import org.assertj.core.api.AbstractAssert;

public abstract class AbstractTestNG {
    protected <T extends AbstractAssert> T logAssert(T abstractAssert) {
        return abstractAssert;
    }
}
