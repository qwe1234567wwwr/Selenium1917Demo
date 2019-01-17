package com.xiaoyan.day02;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.net.idn.Punycode;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    /**
     * 我要点击百度首页的新闻链接
     */
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置谷歌路径
        System.setProperty("webdriver.chrome.driver", "E:\\workplace\\SeleniumDemo190106\\driverss\\chromedriver.exe");
        //实例化谷歌,WebDriver是父类，ChromeDriver是子类，close方法在父类里面，可以直接调用
        driver = new ChromeDriver();
    }
    @Test
    public void clickTest() throws InterruptedException {

        //获取百度地址
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        //定位元素
        WebElement newslink = driver.findElement(By.cssSelector("#u_sp > a:nth-child(1)"));
        //点击元素
        newslink.click();
        //获取当前页面的url
        String url = driver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /**
     * 打开百度首页
     * 输入selenium
     * 点击百度一下进行搜索
     * 校验title是否等于selenium_百度搜索
     */
    @Test
    public void sendkeyTest() throws InterruptedException {
        //获取百度地址
        driver.get("http://www.baidu.com");
        //定位百度搜索框
        WebElement keys = driver.findElement(By.id("kw"));
        //输入框输入文本
        keys.sendKeys("selenium");
        //定位百度搜索按钮
        WebElement dian = driver.findElement(By.id("su"));
        //点击
        dian.click();
        Thread.sleep(5000);
        //获取页面title
        String title = driver.getTitle();
        //做校验
        Assert.assertEquals(title,"selenium_百度搜索");
    }
    @Test
    public void clearTest() throws InterruptedException {
        //获取百度地址
        driver.get("http://www.baidu.com");
        //定位百度搜索框
        WebElement keys = driver.findElement(By.id("kw"));
        //输入框输入文本
        keys.sendKeys("selenium");
        Thread.sleep(5000);
        //清空文本框
        keys.clear();
        Thread.sleep(5000);
    }
    /**
     * 打开百度首页
     * 输入关键字selenium
     * 获取搜索框的文本
     * 校验是否为selenium
     * 清除文本框
     * 再次获取输入框文本
     * 校验文本是否为空
     */
    @Test
    public void clearTest2() throws InterruptedException {
        //获取百度地址
        driver.get("http://www.baidu.com");
        //定位百度搜索框
        WebElement keys = driver.findElement(By.id("kw"));
        //输入框输入文本
        keys.sendKeys("selenium");
        Thread.sleep(5000);
        String text1 = keys.getText();
        //清空文本框
        keys.clear();
        Thread.sleep(5000);
        String text2 = keys.getText();
        Assert.assertEquals(text1,"selenium");
        Assert.assertEquals(text2,"");
    }

    /**
     * 打开百度首页
     * 获取文本框的tagname
     * 校验是否为input
     */
    @Test
    public void getTagNameTest(){
        driver.get("http://www.baidu.com");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }

    /**
     * 打开百度页面
     * 判断按钮显示的文本值为百度一下
     */
    @Test
    public void getATest(){
        driver.get("http://www.baidu.com");
        String attribute = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attribute,"百度一下");
    }

    /**
     * 打开百度首页
     * 判断是否显示百度一下按钮
     */
    @Test
    public void isDisplayedTest(){
        driver.get("http://www.baidu.com");
        Boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面
     * 判断单选框是否被选中
     */
    @Test
    public void isSelectedTest(){
        driver.get("http://www.baidu.com");
        WebElement element= driver.findElement(By.xpath("/input[1]"));
        element.click();
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    /***
     * 打开测试页面
     * 判断submit按钮处于未激活状态
     */
    @Test
    public void isEnabledTest(){
        driver.get("http://www.baidu.com");
        Boolean element= driver.findElement(By.name("/input[1]")).isEnabled();
        Assert.assertFalse(element);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest(){
        driver.get("http://www.baidu.com");
        //截图
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            //将截图放在某个路径中
            FileUtils.copyFile(file,new File("D:\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
