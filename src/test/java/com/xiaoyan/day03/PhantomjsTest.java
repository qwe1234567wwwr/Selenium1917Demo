package com.xiaoyan.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomjsTest {
    @Test
    public void pjsTest() throws InterruptedException {
        //设置phantomjs的路径
        System.setProperty("phantomjs.binary.path","E:\\workplace\\SeleniumDemo190106\\driverss\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(5000);
        String a = driver.getTitle();
        System.out.println(a);
        driver.quit();
    }
}
