package com.xiaoyan.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseBrowserT {
    @Test
    public void closeChrome(){
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver","E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        WebDriver webDriver = new ChromeDriver();
        //线程等待5s,参数中直接输入5000即可
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭浏览器
        webDriver.close();
    }

    @Test
    public void closeChrome2(){
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver","E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        WebDriver webDriver = new ChromeDriver();
        //线程等待5s,参数中直接输入5000即可
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //完全退出
        webDriver.quit();
    }
}
