package com.test.android;

import com.test.factory.AndroidFactory;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by maninder.jeet on 7/6/2017.
 */

public class AndroidTests {


    @Test
    public void testDriverLaunch()
    {
        AndroidDriver driver=AndroidFactory.getDriver();
        driver.launchApp();
        WebElement cnbcLogo=driver.findElementByClassName("android.widget.ImageView");
        Assert.assertTrue(cnbcLogo.isDisplayed(),"CNBC Logo Is Not Displayed");
    }
}
