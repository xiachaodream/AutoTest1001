package com.api.study;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class InitDriver {
    public static AndroidDriver createDriverWithInstall(String platformName,String appPackage,String appActivity,String udid) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "模拟器");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        return new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    public static AndroidDriver createDriverWithUninstall(String platformName,String apk_path) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "模拟器");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "127.0.0.1:62001");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apk_path);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN,true);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        return new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    public static AndroidDriver createDriverWithMobileBrowser(String udid) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "模拟器");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN,true);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
        //手机浏览器新增参数
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROME_OPTIONS, ImmutableMap.of("w3c",false));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "D:\\soft\\chromedriver_mobile\\chromedriver.exe");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        return new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    public static AndroidDriver createDriverWithWechat(String platformName,String appPackage,String appActivity,String udid) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "模拟器");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "D:\\soft\\chromedriver_mobile\\chromedriver.exe");

        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true);
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName","'");
        options.setExperimentalOption("androidProcess","com.tencent.mm:tools");
        options.setCapability(ChromeOptions.CAPABILITY, options);

        return new AndroidDriver(remoteUrl, desiredCapabilities);
    }
}
