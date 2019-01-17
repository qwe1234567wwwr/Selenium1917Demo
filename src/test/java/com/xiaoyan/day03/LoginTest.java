package com.xiaoyan.day03;
import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTest {
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
    public void LoginTest1(){
        LoginTest.loginPo(driver,"qwe1234567wwwr","qwe12345");
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")));
        //写信
        driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
        //定位发信人
        driver.findElement(By.xpath("//*[@title=\"发给多人时地址请以分号隔开\"]")).sendKeys("1575202503@qq.com");
        //定位主题
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("hehehe");
        //上传附件
        driver.findElement(By.className("O0")).sendKeys("C:\\Users\\Administrator\\Desktop\\客户需求改动统计表2018-11-5(总包含已修复和未修复）.xlsx");
        //填写正文
        WebElement j = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(j);
        driver.findElement(By.xpath("/html/body")).sendKeys("zhe");
        //将控制权转交
        driver.switchTo().defaultContent();
        //点击发送
        driver.findElement(By.xpath("//*[@text()=\"发送\"")).click();
    }
    public static void loginPo(WebDriver driver,String email,String pwd){
        WebElement i = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(i);
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        driver.findElement(LoginPage.loginButton).click();

    }
    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
