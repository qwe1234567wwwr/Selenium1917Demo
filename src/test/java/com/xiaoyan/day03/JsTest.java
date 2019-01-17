package com.xiaoyan.day03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver", "E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        driver = new ChromeDriver();
    }
    @Test
    public void exJs() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //实例化js
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //将js的相关属性值修改（谷歌浏览器，f12，console执行js代码）
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\");");
        Thread.sleep(5000);
    }



    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
