package com.po.page;
import org.openqa.selenium.By;
public class LoginPage {//把一个页面所有用到的定位元素都放在这里
   //返回值类型by代表是返回的定位方式,定义email文本框的定位方式
    public static By emailInput = By.name("email");
    //定义密码输入框的定位方式
    public static By pwdInput = By.name("password");
    //定义登录按钮的定位方式
    public static  By loginButton = By.id("dologin");
    //定义去注册的定位方式
    public static  By zhuce = By.id("changepage");

}
