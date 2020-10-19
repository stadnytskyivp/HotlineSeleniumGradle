package com.hotline.helpers;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class ReusableMethods {
    public static String getRandomUsername() {
        Random random = new Random();
        return Long.toString(Math.abs(random.nextLong() % 3656158440062976L), 36);
    }

    public static String getRandomNumber() {
        Random random = new Random();
        return Long.toString(Math.abs(random.nextLong() % 365615844L));
    }

    public static String getRandomPhoneNumber() {
        Random random = new Random();
        String numberStr = Long.toString(Math.abs(random.nextLong() % 9999999L));
        if (numberStr.length() < 7) {
            numberStr = numberStr + "0";
        }
        return ("+38093" + numberStr);
    }

    public static void compareErrors(int i, List<WebElement> actualErrors, List<EErrors> expectedErrors) {
        while (i != 0) {
            Assert.assertEquals(expectedErrors.get(i - 1).getError(), actualErrors.get(i - 1).getText());
            i--;
        }
    }
}
