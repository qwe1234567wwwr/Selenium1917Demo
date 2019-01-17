package com.xiaoyan.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;


public class WindowSelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver", "E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        driver = new ChromeDriver();
    }
    /**
     * 打开测试界面
     * 点击open new window
     * 在新的窗口点击百度
     */
    @Test
    public void testWin() throws InterruptedException {
        driver.get("http://www.baidu.com");
        driver.findElement(By.linkText("Open new Windwow")).click();
        Thread.sleep(3000);
        //获取当前页面的handle值
        //String handle1 = driver.getWindowHandle();
        //获取当前driver所在的页面的handle值（句柄值）
        String handle1 = driver.getWindowHandle();
        //for循环判断获取到的handles是否是等于handle1
        for(String handles:driver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;//结束本次循环继续执行；break，结束整个循环，return结束整个代码F7，F8调试执行
            }else{
                driver.switchTo().window(handles);
            }
        }
        //driver.switchTo().window();
        driver.findElement(By.linkText("baidu")).click();
    }


    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
