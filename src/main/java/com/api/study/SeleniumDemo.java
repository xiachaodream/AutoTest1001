package com.api.study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SeleniumDemo {
    WebDriver driver;
    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:\\soft\\chromedriver_win32\\chromedriver.exe");
         driver= new ChromeDriver();
    }
    @Test
    public void login(){
     driver.get("http://www.baidu.com");
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
