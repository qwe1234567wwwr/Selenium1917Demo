package com.xiaoyan.day02;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
            WebDriver driver;
            @BeforeMethod
            public void openChrome(){
                //设置谷歌路径
                System.setProperty("webdriver.chrome.driver", "E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
                //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
                driver = new ChromeDriver();
            }
            /**
             * 打开ui自动化测试主页
             * 点击Alert按钮
             * 在alert警告框点击确定按钮
             */
            @Test
            public void alertTest() throws InterruptedException {
                driver.get("http://www.baidu.com");
                driver.findElement(By.className("niah1")).click();
                //将driver的控制权全部转交给alert
                Alert alert = driver.switchTo().alert();
                String text = alert.getText();
                Assert.assertEquals(text,"请点击确定");
                //建议加一个等待
                Thread.sleep(3000);
                //点击确定按钮
                alert.accept();
            }
            @Test
            public void confirmTest() throws InterruptedException {
                driver.get("http://www.baidu.com");
                driver.findElement(By.className("niah1")).click();
                //将driver的控制权全部转交给alert
                Alert alert = driver.switchTo().alert();
                //建议加一个等待
                Thread.sleep(3000);
                //点击取消按钮
                alert.dismiss();
                Thread.sleep(3000);
                //点击确定
                alert.accept();
            }
            @Test
            public void promptTest() throws InterruptedException {
                driver.get("http://www.baidu.com");
                driver.findElement(By.className("niah1")).click();
                //将driver的控制权全部转交给alert
                Alert alert = driver.switchTo().alert();
                //建议加一个等待
                Thread.sleep(3000);
                //弹框中输入文本
                alert.sendKeys("nihao1");
                Thread.sleep(3000);
                //点击确定
                alert.accept();
                Thread.sleep(3000);
                alert.accept();
            }

            @AfterMethod
            public void closed() throws InterruptedException {
                Thread.sleep(3000);
                driver.quit();
            }
        }
