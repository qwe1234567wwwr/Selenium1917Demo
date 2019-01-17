package com.xiaoyan.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

public class BrowserActionTest {
    WebDriver driver;
    /**
     * 打开谷歌浏览器
     * 打开百度首页
     * 等待5s
     * 关闭浏览器
     */
    @Test
    public void getTest() throws InterruptedException {
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver","E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        WebDriver driver = new ChromeDriver();
        //链接百度
        driver.get("http://www.baidu.com");
        //等待5s
        Thread.sleep(5000);
        //关闭浏览器
        driver.quit();
    }
    /**
     * 打开谷歌浏览器
     * 打开百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void winTest() throws InterruptedException {
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver","E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        WebDriver driver = new ChromeDriver();
        //实例化DImension类，设置窗口大小
        Dimension dimension = new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        //等待3s
        Thread.sleep(3000);
        //最大化浏览器
        driver.manage().window().maximize();
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器
        driver.quit();
    }
    /**
     * 打开谷歌浏览器
     * 打开百度首页
     * 等待3s
     * 获取当前页面的url
     * 校验当前页面url是不是百度地址
     * 关闭浏览器
     */
    @Test
    public void getUrlTest(){
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver","E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        driver = new ChromeDriver();
        //打开百度地址
        driver.get("http://www.baidu.com");
        //获取当前url,该方法有返回值
        String url = driver.getCurrentUrl();
        System.out.println("获取到的URL是："+url);
        //校验是不是百度地址
        Assert.assertEquals(url,"https://www.baidu.com/");
        //关闭浏览器
        driver.close();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
