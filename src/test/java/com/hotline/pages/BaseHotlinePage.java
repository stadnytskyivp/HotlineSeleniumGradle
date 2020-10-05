package com.hotline.pages;

import com.hotline.modules.HeaderModule;

public class BaseHotlinePage<T extends BaseHotlinePage> {
    private HeaderModule headerModule = new HeaderModule();

    public HeaderModule getHeaderModule() {
        return headerModule;
    }
}
