package com.api.study;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PingduoduoDemo {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        driver = InitDriver.createDriverWithInstall(
                "Android",
                " com.xunmeng.pinduoduo",
                ".ui.activity.MainFrameActivity",
                "8KE5T19A16005421"
        );
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }

    /**
     *自动浇水
     */
    @Test
    public void water() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//*[@text='多多果园']")).click();
            int waterNum = getWaterNum();
            while (waterNum>10){//TODO中间可能有弹出框--去浇水
                if(isElementExist(By.xpath("//*[text='commonPopupCloseButtonV2']"))){
                    driver.findElement(By.xpath("//*[text='commonPopupCloseButtonV2']")).click();
                }
                //意外之喜
                if(isElementExist(By.xpath("//*[text='reward_after_water_gift']"))){
                    driver.findElement(By.xpath("//*[text='reward_after_water_gift']")).click();
                    driver.findElement(By.xpath("//*[text='commonPopupCloseButtonV2']")).click();
                }
                //关掉弹框
                if(isElementExist(By.xpath("//*[text='commonPopupCloseButtonV2']"))){
                    driver.findElement(By.xpath("//*[text='commonPopupCloseButtonV2']")).click();
                }
                WebDriverWait wait = new WebDriverWait(driver,20);
                List<AndroidElement> elements = driver.findElements(By.xpath("//*[text='去浇水']"));
                if(elements!=null&&elements.size()>0){
                    elements.get(0).click();
                }
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='bottle_default_bg']"))).click();
                waterNum=getWaterNum();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //处理开福袋弹框-关闭
    @Test
    public void openFUBag(){
        //检查是否有弹框，有就关闭
        List<AndroidElement> elements = driver.findElements(By.xpath("//*[@text='icon_cancel_bless']"));
        if(elements!=null&&elements.size()>0){
            elements.get(0).click();
        }
    }

    //浏览商品1分钟
    @Test
    public void viewGoods() throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='多多果园']")).click();
        driver.findElement(By.xpath("//*[@text='getWater_v4']")).click();
        if(isElementExist(By.xpath("//*[@text='去完成' and @resource-id='29']"))){
            driver.findElement(By.xpath("//*[@text='去完成' and @resource-id='29']")).click();
            if(isElementExist(By.xpath("//*[@text='去拼单']"))){
                driver.findElement(By.xpath("//*[@text='去拼单']")).click();
            }
            swipe();
        }
    }

    //浏览爆款会场
    @Test
    public void viewHotItems() throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='多多果园']")).click();
        driver.findElement(By.xpath("//*[@text='getWater_v4']")).click();
        if(isElementExist(By.xpath("//*[@text='去完成' and @resource-id='30026']"))){
            driver.findElement(By.xpath("//*[@text='去完成' and @resource-id='30026']")).click();
            if(isElementExist(By.xpath("//*[@text='7df5b454-8b3e-46a4-b887-a7b1adbd379a']"))){
                driver.findElement(By.xpath("//*[@text='7df5b454-8b3e-46a4-b887-a7b1adbd379a']")).click();
                driver.findElement(By.xpath("//*[@text='当前页面拼单立得200g水滴']/following-sibling::*[1]")).click();
            }
            swipe();
        }
    }

    @Test
    public void getWater() throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='getWater_v4']")).click();
        if(isElementExist(By.xpath("//*[@text='打卡']"))){
            driver.findElement(By.xpath("//*[@text='打卡']")).click();
        }
        if(isElementExist(By.xpath("//*[@text='去领取' and @resource-id='1']"))){
            driver.findElement(By.xpath("//*[@text='去领取' and @resource-id='1']")).click();
            driver.findElement(By.xpath("//*[@text='获得更多水滴']")).click();
        }
        if(isElementExist(By.xpath("//*[@text='去领取' and @resource-id='14']"))){
            driver.findElement(By.xpath("//*[@text='去领取' and @resource-id='14']")).click();
        }

        if(isElementExist(By.xpath("//*[@text='去完成' and @resource-id='30026']"))){
            driver.findElement(By.xpath("//*[@text='去完成' and @resource-id='30026']")).click();
            swipe();
        }
        //观看视频得水滴
        if(isElementExist(By.xpath("//*[@text='去完成' and @resource-id='30029']"))){
            driver.findElement(By.xpath("//*[@text='去完成' and @resource-id='30029']")).click();
            Thread.sleep(1000*120);
            TouchAction action = new TouchAction(driver);
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            action.tap(PointOption.point(width/2,height/2));
            driver.findElement(By.xpath("//*[@text='去看直播']")).click();
            driver.navigate().back();//TODO,返回键
        }
        if(isElementExist(By.xpath("//*[@text='去完成' and @resource-id='30042']"))){
            driver.findElement(By.xpath("//*[@text='去完成' and @resource-id='30042']")).click();
            swipe();
            driver.findElement(By.xpath("//*[@text='顶部']")).click();
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='领取奖励']"))).click();
            driver.navigate().back();
        }
        //浏览视频得水滴
        if(isElementExist(By.xpath("//*[@text='去完成' and @resource-id='30059']"))){
            driver.findElement(By.xpath("//*[@text='去完成' and @resource-id='30059']")).click();
            swipe();
            driver.navigate().back();
        }

        while (isElementExist(By.xpath("//*[@text='领取']"))){
            List<AndroidElement> elements = driver.findElements(By.xpath("//*[@text='领取']"));
                elements.get(0).click();
        }


    }
    public void swipe() throws InterruptedException {
        Thread.sleep(2000);
        long target = System.currentTimeMillis() + 1000 * 62;
        while (System.currentTimeMillis()<=target){
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(width/2,2*height/3)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                    .moveTo(PointOption.point(width/2,height/3))
                    .release().perform();
        }
    }

    public boolean isElementExist(By by){
        List<AndroidElement> elements = driver.findElements(by);
        if(elements!=null&&elements.size()>0){
            return true;
        }
        return false;
    }

    public int getWaterNum(){
        String text = driver.findElement(By.xpath("//*[@resource-id='waterbottle']/*[3]")).getText();
        System.out.println(text);
        text=text.substring(0,text.length()-1);
        int waterNum = Integer.parseInt(text);
        return waterNum;
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    public static void main(String[] args) {
        long target = System.currentTimeMillis() + 1000 * 60;
        while (System.currentTimeMillis()<=target){
            System.out.println("--------");
        }
        System.out.println("end-------");

    }
}
