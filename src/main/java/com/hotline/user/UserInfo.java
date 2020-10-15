package com.hotline.user;

import com.hotline.helpers.ReusableMethods;
import com.hotline.tools.XmlDataLoader;

import java.io.IOException;

public class UserInfo {
    private static final String USER_EMAIL = "userEmail";
    private static final String USER_PASSWORD = "userPassword";

    public static User newUser() {
        return new User()
            .setLogin(String.format("%s@gmail.com", ReusableMethods.getRandomUsername()))
            .setPassword(ReusableMethods.getRandomUsername())
            .setName(ReusableMethods.getRandomUsername());
    }

    public static User myUser() throws IOException {
        return new User()
            .setLogin(XmlDataLoader.getProperty(USER_EMAIL))
            .setPassword(XmlDataLoader.getProperty(USER_PASSWORD))
            .setName(ReusableMethods.getRandomUsername());
    }
}
