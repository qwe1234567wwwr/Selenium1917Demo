package com.xiaoyan.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.ws.RequestWrapper;

public class FindElementsTest {
    /**
     * 打开百度页面
     * 定位搜索文本框
     */
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome(){

        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver","E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        webDriver = new ChromeDriver();
    }
    @Test
    public void byIdTest(){
        //打开百度页面
        webDriver.get("http://www.baidu.com");
        //找到相应的元素,有返回类型
        WebElement keyField = webDriver.findElement(By.className("wd"));
    }
    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
