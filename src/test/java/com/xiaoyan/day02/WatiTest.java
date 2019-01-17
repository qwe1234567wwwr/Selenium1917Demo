package com.xiaoyan.day02;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WatiTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver", "E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        driver = new ChromeDriver();
        //加一个全局等待
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//30是超时时间，后面表示单位
    }
    /**
     * 打开测试界面
     * 点击wait按钮
     * 获取文本，并判断是否为“wait for display”
     */
    @Test
    public void waitTest() throws InterruptedException {
        //打开测试界面
        driver.get("http://www.baidu.com");
        driver.findElement(By.xpath("//@dfer1")).click();
        //机器没有那么智能，点击按钮之后，下面的文字出现了，但是代码可能还没有更新，所有点击后再加一个等待，全局等待加载实例化谷歌浏览器后面
        //实例化类,
        WebDriverWait wait = new WebDriverWait(driver,10);
        //以下方法传入的值是定位方式的值,一直等待这个元素加载，超时没有找到就会抛出错误。，找到了马上执行下面的代码
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//32543dgd")));
        String text = driver.findElement(By.xpath("//34534635")).getText();
        Assert.assertEquals(text,"wait for display");
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }
}
