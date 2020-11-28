package com.api.study;

import com.api.utils.AppiumUtil;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import javafx.scene.input.KeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeChatDemo {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        driver = InitDriver.createDriverWithInstall(
                "Android",
                "com.tencent.mm",
                ".ui.LauncherUI",
                "8KE5T19A16005421"
        );
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void gestureTest(){
        List<AndroidElement> elements = driver.findElements(By.id("com.tencent.mm:id/cnh"));
        elements.get(elements.size()-1).click();
        driver.findElement(By.id("com.tencent.mm:id/ab7")).click();
        AndroidElement unlock = (AndroidElement)driver.findElement(By.id("com.tencent.mm:id/eah"));
        AppiumUtil util = new AppiumUtil(driver);
        util.unlock(unlock,"1536841");
    }

    @Test
    public void snedMoneyToPerson(){
        driver.findElementByAccessibilityId("搜索").click();
        driver.findElement(By.id("com.tencent.mm:id/bhn")).sendKeys("老婆大人");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.tencent.mm:id/gbv"))).click();
        driver.findElementByAccessibilityId("更多功能按钮，已折叠").click();
        driver.findElement(By.xpath("//*[@text='红包']")).click();
        driver.findElement(By.id("com.tencent.mm:id/dbc")).sendKeys("0.01");
        driver.findElement(By.xpath("//*[@text='恭喜发财，大吉大利']")).sendKeys("appium自动发送红包");
        WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='塞钱进红包']")));
        ele.click();
        AndroidElement element = (AndroidElement)driver.findElement(By.id("com.tencent.mm:id/g61"));
        new AppiumUtil(driver).sentMoney(element,"570816");


    }
    @Test
    public void snedMoneyToGroup(){
        driver.findElementByAccessibilityId("搜索").click();
        driver.findElement(By.id("com.tencent.mm:id/bhn")).sendKeys("appiumTest");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.tencent.mm:id/gbv"))).click();
        driver.findElementByAccessibilityId("更多功能按钮，已折叠").click();
        driver.findElement(By.xpath("//*[@text='红包']")).click();
        driver.findElement(By.id("com.tencent.mm:id/dbc")).sendKeys("0.01");
        driver.findElement(By.xpath("//*[@text='填写个数']")).sendKeys("1");
        driver.findElement(By.xpath("//*[@text='恭喜发财，大吉大利']")).sendKeys("appium自动发送红包");
        WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='塞钱进红包']")));
        ele.click();
        AndroidElement element = (AndroidElement)driver.findElement(By.id("com.tencent.mm:id/g61"));
        new AppiumUtil(driver).sentMoney(element,"570816");
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
