package com.xiaoyan.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    @Test
    public void openFF(){
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void openFF2(){
        System.setProperty("webdriver.firefox.bin","E:\\杨钒测试\\Mozilla Firefox\\firefox.exe");
        //实例化一个火狐driver
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void openChrome(){
        //告知机器，driver的路径
        System.setProperty("webdriver.chrome.driver","E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化浏览器
        WebDriver webDriver = new ChromeDriver();
    }
    @Test
    public void openIE(){
        //告知机器，driver的路径
        System.setProperty("webdriver.ie.driver","E:\\workplace\\SeleniumDemo190106\\driverss\\IEDriverServer.exe");
        //实例化浏览器
        WebDriver webDriver = new InternetExplorerDriver();
    }
}
