package com.hotline.user;

import com.hotline.helpers.ReusableMethods;
import com.hotline.tools.XmlDataLoader;

import java.io.IOException;

public class UserInfo {
    public static User newUser() {
        return new User()
            .setLogin(String.format("%s@gmail.com", ReusableMethods.getRandomUsername()))
            .setPassword(ReusableMethods.getRandomUsername())
            .setName(ReusableMethods.getRandomUsername());
    }

    public static User myUser() throws IOException {
        return new User()
            .setLogin(XmlDataLoader.getProperty(EUser.USER_EMAIL))
            .setPassword(XmlDataLoader.getProperty(EUser.USER_PASSWORD))
            .setName(ReusableMethods.getRandomUsername());
    }
}
