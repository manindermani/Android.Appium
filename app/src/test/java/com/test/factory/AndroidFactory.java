package com.test.factory;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Created by maninder.jeet on 7/6/2017.
 */

public class AndroidFactory {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver()
    {
        try {
            driver.getTitle();
        }
        catch(Exception ex)
        {
                AndroidFactory.setUpDriver();

        }
        return driver;
    }

    private static void setUpDriver()
    {
        String path=System.getProperty("user.dir");
        File apkPath=new File(path,"CNBC.apk");
        System.out.println("Installing Application: "+apkPath.getAbsolutePath());
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.APP,apkPath);
        capabilities.setCapability("appPackage", "com.cnbc.client");
        capabilities.setCapability("autoLaunch",false);
        try {
            driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
