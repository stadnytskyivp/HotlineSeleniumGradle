package com.hotline.webdriver;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Browser {
    FIREFOX("firefox"),
    CHROME("chrome"),
    EDGE("edge");

    String name;

    Browser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Browser getByName(String name) {
        return Stream.of(values())
            .filter(browser -> browser.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Cannot recognize driver type: [" + name + "]. Use one of: " + getAllNames()));
    }

    private static String getAllNames(){
        return Stream.of(values())
            .map(Browser::getName)
            .collect(Collectors.joining(", "));
    }
}
