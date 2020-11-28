package com.api.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppiumUtil {
    AndroidDriver driver;
    TouchAction touch;
    int x;
    int y;
    public AppiumUtil(AndroidDriver driver){
        this.driver=driver;
        touch=new TouchAction(driver);
        x=driver.manage().window().getSize().width;
        y=driver.manage().window().getSize().height;
    }

    public void swipToUp(){
        touch.press(PointOption.point(x/2,4*y/5))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x/2,y/5))
        .release().perform();
    }

    public void swipToDown(){
        touch.press(PointOption.point(x/2,y/5))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x/2,4*y/5))
                .release().perform();
    }

    public void swipToLeft(){
        touch.press(PointOption.point(4*x/5,y/2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x/5,y/2))
                .release().perform();
    }

    public void swipToRight(){
        touch.press(PointOption.point(x/5,y/2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(4*x/5,y/2))
                .release().perform();
    }

    public void swip(int start_x,int start_y,int end_x,int end_y){
        touch.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x,end_y))
                .release().perform();
    }

    public void ele_swip(AndroidElement ele,String direction){
        int ele_width = ele.getSize().getWidth();
        int ele_height = ele.getSize().getHeight();
        int start_x=ele.getLocation().getX();
        int start_y=ele.getLocation().getY();
        switch (direction.toLowerCase()){
            case "up" :
                touch.press(PointOption.point(start_x+ele_width/2,start_y+4*ele_height/5))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(start_x+ele_width/2,start_y+ele_height/5))
                        .release().perform();
                break;
            case "down" :
                touch.press(PointOption.point(start_x+ele_width/2,start_y+ele_height/5))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(start_x+ele_width/2,start_y+4*ele_height/5))
                        .release().perform();
                break;
            case "left" :
                touch.press(PointOption.point(start_x+4*ele_width/5,start_y+ele_height/2))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(start_x+ele_width/5,start_y+ele_height/2))
                        .release().perform();
                break;
            case "right" :
                touch.press(PointOption.point(start_x+ele_width/5,start_y+ele_height/2))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(start_x+4*ele_width/5,start_y+ele_height/2))
                        .release().perform();
                break;
        }
    }

    public void unlock(AndroidElement ele,String gesture){
        List<PointOption> pointOptions = new ArrayList<PointOption>();
        int start_x=ele.getLocation().getX();
        int start_y=ele.getLocation().getY();
        int width = ele.getSize().getWidth();
        int height = ele.getSize().getHeight();

        for(int i=1;i<4;i++){
            for(int j=1;j<4;j++){
                pointOptions.add(PointOption.point(start_x+(2*j-1)*width/6,start_y+(2*i-1)*height/6));
            }
        }
        char[] chars = gesture.toCharArray();
        touch.press(pointOptions.get(0)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
        for(int i=1;i<chars.length;i++){//1536841
            int num = Integer.parseInt(String.valueOf(chars[i]));
            touch. moveTo(pointOptions.get(num-1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
        }
        touch.release().perform();

    }
    public void sentMoney(AndroidElement ele,String password){
        List<PointOption> pointOptions = new ArrayList<PointOption>();
        int start_x=ele.getLocation().getX();
        int start_y=ele.getLocation().getY();
        int width = ele.getSize().getWidth();
        int height = ele.getSize().getHeight();

        for(int i=1;i<4;i++){
            for(int j=1;j<4;j++){
                pointOptions.add(PointOption.point(start_x+(2*j-1)*width/6,start_y+(2*i-1)*height/6));
            }
        }
        //特殊处理0
        int special0_x=start_x+width/2;
        int special0_y=start_y+9*height/10;
        pointOptions.add(PointOption.point(special0_x,special0_y));
        char[] chars = password.toCharArray();
        for(int i=0;i<chars.length;i++){
            int num = Integer.parseInt(String.valueOf(chars[i]));
            if(num==0){
                touch.tap(pointOptions.get(pointOptions.size()-1)).release().perform();
            }else{
                touch.tap(pointOptions.get(num-1)).release().perform();
            }
        }



    }


}
