package com.api.study;

import com.api.utils.AppiumUtil;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumDemo {

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
        driver = InitDriver.createDriverWithUninstall("Android", "D:\\document\\douban.apk");
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void login() throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementById("com.douban.frodo:id/left");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.douban.frodo:id/input_user_name");
        el2.sendKeys("18698587191");
        MobileElement el3 = (MobileElement) driver.findElementById("com.douban.frodo:id/input_password");
        el3.sendKeys("jx123456");
        MobileElement el4 = (MobileElement) driver.findElementById("com.douban.frodo:id/sign_in_douban");
        el4.click();
        AppiumUtil appiumUtil = new AppiumUtil(driver);
        for(int i=0;i<5;i++){
            appiumUtil.swipToUp();
        }

        driver.findElement(MobileBy.AndroidUIAutomator("text(\"我的\")")).click();
        MobileElement nickname = (MobileElement) driver.findElementById("com.douban.frodo:id/name");
        Assert.assertEquals(nickname.getText(),"xiachao");
    }

    @Test(dependsOnMethods = {"login"})
    public void updatePersonInfo(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='个人主页']")).click();
        driver.findElement(By.id("com.douban.frodo:id/card_edit_profile_btn")).click();
        driver.findElement(By.xpath("//*[@text='简介']/following-sibling::*[1]")).sendKeys("hello world");
        driver.findElement(By.id("com.douban.frodo:id/save")).click();
        String desc = driver.findElement(By.id("com.douban.frodo:id/card_user_info_intro")).getText();
        Assert.assertEquals(desc,"hello world");
    }
    @Test(dependsOnMethods = {"login"})
    public void swipeTest() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@text='个人主页']")).click();
        driver.findElement(By.id("com.douban.frodo:id/card_edit_profile_btn")).click();
        driver.findElement(By.id("com.douban.frodo:id/birthday")).click();
        List<AndroidElement> elements = driver.findElements(By.className("android.widget.NumberPicker"));
        AndroidElement yearEle = elements.get(0);
        AndroidElement monthEle = elements.get(1);
        AndroidElement dayEle = elements.get(2);
        AppiumUtil util = new AppiumUtil(driver);
        Thread.sleep(1000);
        util.ele_swip(yearEle,"up");
        util.ele_swip(monthEle,"up");
        util.ele_swip(dayEle,"down");

        driver.findElement(By.xpath("//*[@text=\"确定\"]")).click();



    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
