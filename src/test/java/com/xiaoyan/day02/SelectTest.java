package com.xiaoyan.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
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
     * 下拉框选择vivo
     * 第二次选择huawei
     * 第三次选择iphone
     */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement selectEl = driver.findElement(By.id("moreSelect"));
        //实例化Select类
        Select select = new Select(selectEl);
        //通过索引值下拉选择
        select.selectByIndex(2);
        Thread.sleep(3000);
        //通过value值做下拉选择
        select.selectByValue("value");
        Thread.sleep(3000);
        //通过文本值做下拉选择
        select.selectByVisibleText("iphone");
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
