package com.xiaoyan.day02;

import com.sun.xml.internal.ws.model.WrapperBeanGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.ws.WebEndpoint;

public class IframeTest {
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
     * 点击百度链接
     */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //driver.switchTo().frame("aaa");
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        //将控制权移交回来
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登录界面")).click();
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
