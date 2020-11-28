package com.api.study;

import com.api.utils.AppiumUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MobileBroswerDemo {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        driver = InitDriver.createDriverWithMobileBrowser(
                "8KE5T19A16005421"
        );
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


    @Test
    public void myTest() throws InterruptedException {
        driver.get("https://m.58.com/hz/");
        Set<String> contextHandles = driver.getContextHandles();
        for(String context:contextHandles){
            System.out.println(context);
        }
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//*[@text='允许']")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='仅使用期间允许']"))).click();

        driver.context("CHROMIUM");
        driver.findElement(By.xpath("//div[@class='app_pop_close']")).click();
        driver.findElement(By.xpath("//span[text()='招聘']/..")).click();
        driver.findElement(By.xpath("//span[text()='写简历']/..")).click();
        driver.findElement(By.xpath("//*[@id='toutu_list']/following-sibling::*[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='type_img my_img']")).click();
        driver.context("NATIVE_APP");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='始终允许']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@resource-id='com.android.chrome:id/bitmap_view'])[3]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.chrome:id/done"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='选取']"))).click();

        driver.context("CHROMIUM");
        driver.findElement(By.id("txtUserName")).sendKeys("test_name");
        driver.findElement(By.xpath("//input[@class='inp_rad']")).click();
        driver.findElement(By.id("year")).click();

        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//*[@text='2000']")).click();
        driver.context("CHROMIUM");
//        action.tap(PointOption.point(width/2,height/2)).release().perform();
        String year = driver.findElement(By.xpath("//span[@message='请选择您的出生年份']")).getText();
        System.out.println(year);
        Assert.assertNotNull(year);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
