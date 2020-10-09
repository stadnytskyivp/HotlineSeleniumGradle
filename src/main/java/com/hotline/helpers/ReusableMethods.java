package com.hotline.helpers;

import java.util.Random;

public class ReusableMethods {
    public static String getRandomUsername() {
        Random random = new Random();
        return Long.toString(Math.abs(random.nextLong() % 3656158440062976L), 36);
    }
}
