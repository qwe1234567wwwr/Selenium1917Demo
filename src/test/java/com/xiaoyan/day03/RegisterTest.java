package com.xiaoyan.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver", "E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }
    @Test
    public void registerTest() throws InterruptedException {
        //将控制权转交给iframe里面
        //driver.switchTo().frame("x-URS-iframe1547281163352.9849");
        //由于这个id是随机变化的，就不能用id来定位,用tagname
        WebElement i = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(i);
        driver.findElement(By.id("changepage")).click();
        //获取当前driver的handle值
        String handle1 = driver.getWindowHandle();
        //driver切换到新的window页面
        for(String handles : driver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }
        //输出13位的时间戳，从1970年1月1日开始，每秒值都不一样，可以将该值作为邮件地址
        //视频中run错了，原因是邮箱值像电话值，系统额外弹出一个框，导致运行失败，以后报错按照脚本排查一下这样的问题
        String time = String.valueOf(System.currentTimeMillis());
        driver.findElement(By.id("nameIpt")).sendKeys("a"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123123");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123123");
        driver.findElement(By.id("mainMobileIpt")).sendKeys("12345678901");
        //希望开发给一个万能验证码；或者是直接把验证码的功能干掉，不用这个
        driver.findElement(By.id("vcodeIpt")).sendKeys("1234");
        //输入手机验证码,找开发帮忙，弄一个万能验证码
        String mobile = String.valueOf(System.currentTimeMillis()/100);
        driver.findElement(By.id("mainAcodeIpt")).sendKeys(mobile);
        //点击立即注册
        driver.findElement(By.id("mainRegA")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        //以下方法传入的值是定位方式的值,一直等待这个元素加载，超时没有找到就会抛出错误。，找到了马上执行下面的代码
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainAcode\"]/span")));
        //获取失败的文本
        String error = driver.findElement(By.id("//*[@id=\"m_mainAcode\"]/span")).getText();
        Assert.assertEquals(error,"  手机验证码不正确，请重新填写");
    }
    @AfterMethod
    public void closed()
    {
        driver.quit();
    }
}