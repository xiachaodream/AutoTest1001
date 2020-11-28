package com.api.study;

import com.api.utils.AppiumUtil;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KuaiShouDemo {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        /*DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "模拟器");
        desiredCapabilities.setCapability("udid", "127.0.0.1:62001");
        desiredCapabilities.setCapability("newCommandTimeout", "600");
        desiredCapabilities.setCapability("unicodeKeyboard", true);
        desiredCapabilities.setCapability("resetKeyboard", true);
        desiredCapabilities.setCapability("appPackage", "com.douban.frodo");
        desiredCapabilities.setCapability("appActivity", "com.douban.frodo.activity.SplashActivity");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);*/
        driver = InitDriver.createDriverWithInstall("Android", "com.kuaishou.nebula","com.yxcorp.gifshow.HomeActivity","8KE5T19A16005421");
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        long target = System.currentTimeMillis() + 1000 * 60*60*2;
        while (System.currentTimeMillis()<=target){
            Thread.sleep(10000);
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(width/2,5*height/6)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                    .moveTo(PointOption.point(width/2,height/6))
                    .release().perform();
        }
    }




    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
