package com.xiaoyan.day02;

import com.sun.corba.se.spi.activation.ActivatorOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionsTest2 {
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
     * 打开百度页面
     * 在百度一下按钮上右键
     */
    @Test
    public void rightClick(){
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化actions类
        Actions actions = new Actions(driver);
        //这个时候就可以使用actions提供给我们的方法,以下是右键,后面一定要跟一个performan()代表执行
        actions.contextClick().perform();
        //actions.contextClick(buttonBaidu).build().perform();这样写和上面代码一模一样
    }

    /**
     * 打开百度页面
     * 双击百度按钮
     */
    @Test
    public void doubleClick(){
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化actions类
        Actions actions = new Actions(driver);
        //这个时候就可以使用actions提供给我们的方法,以下是右键,后面一定要跟一个performan()代表执行
        actions.doubleClick(buttonBaidu).perform();
    }

    /**
     * 打开测试页面
     * 鼠标移动到action按钮
     * 那么显示hello world
     */
    @Test
    public void move() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.xpath("sdfe  1q"));
        Actions actions = new Actions(driver);
        //把元素移动到这个元素
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        String hello = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(hello,"Hello World!");
    }
    @Test
    public void testDrop() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(5000);
    }

    @Test
    public void testDrop2() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //定位被拖动元素
        WebElement el1 = driver.findElement(By.id("drag"));
        //定位另一个元素
        WebElement el2 = driver.findElement(By.xpath("3r543543"));
        Actions actions = new Actions(driver);
        //鼠标按住某个元素然后拖过去,然后释放元素
        actions.clickAndHold(el1).moveToElement(el2).release(el1).perform();
        Thread.sleep(5000);
    }

    @Test
    public void moreSelectTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement el1 = driver.findElement(By.id("multiselect"));
        //通过xpath可以定位到所有元素
        List<WebElement> list = driver.findElements(By.xpath("fegt31e/option"));
        Actions actions = new Actions(driver);
        //鼠标按住shift键,选择第一个和第三个选择框，这个时候前三个选项都被选上
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
        //鼠标按住ctrl键,选择第一个和第三个选择框,这个时候选择的是第一个和第三个选择框(代码默认第一个被选中)。
        //actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
    }

    /**
     *打开百度页面
     * ctrl+s保存我们的页面
     */
    @Test
    public void saveHtmlTest() throws InterruptedException, AWTException {
        driver.get("http://www.baidu.com");
       //实例化Robot类
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        //利用java转化弄成ascll码值
        int keyS = (int)new Character('S');
        robot.keyPress(keyS);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
    }
    @Test
    public void upLoadTest() throws InterruptedException, AWTException {
        driver.get("http://www.baidu.com");
        //如果是input标签可以直接sendKeys
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\Administrator\\Pictures\\123.jpg");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
