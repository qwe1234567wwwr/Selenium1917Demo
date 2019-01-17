package com.xiaoyan.day03;
import org.apache.bcel.generic.NEW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
public class GridTest {//脚本是在hub机器上执行
    @Test
    public void testChrome() throws InterruptedException, MalformedURLException {
        //创建一个DesiredCapabilities类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化一个driver,url参数（hub地址，用hub分发脚本，启动的浏览器从界面第一个开始运行，运行的浏览器会变灰色）
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.105:4446/wd/hub"), dc);
        //如果像指定某个node节点取运行，则url的链接应该写node节点的地址
        //WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.105:4446/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }
    @DataProvider(name = "data4")
    public  Object[][] test1(){
        return new Object[][]{
                {"firefox"},
                {"chrome"}
            };
        }
    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc = null;
        if(browser .contentEquals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if (browser == "chrome"){
            dc = DesiredCapabilities.chrome();
        }else{
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.105:4446/wd/hub"), dc);
        //如果像指定某个node节点取运行，则url的链接应该写node节点的地址
        //WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.105:4446/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }
}
