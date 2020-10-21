package com.hotline.user;

import com.hotline.helpers.ReusableMethods;
import com.hotline.tools.XmlDataLoader;

public class UserInfo {
    private static final String USER_EMAIL = "userEmail";
    private static final String USER_PASSWORD = "userPassword";

    public static User newUser() {
        return new User()
            .setLogin(String.format("%s@gmail.com", ReusableMethods.getRandomUsername()))
            .setPassword(ReusableMethods.getRandomUsername())
            .setName(ReusableMethods.getRandomUsername());
    }

    public static User myUser() {
        return new User()
            .setLogin(XmlDataLoader.getProperty(USER_EMAIL))
            .setPassword(XmlDataLoader.getProperty(USER_PASSWORD))
            .setName(ReusableMethods.getRandomUsername());
    }
}
