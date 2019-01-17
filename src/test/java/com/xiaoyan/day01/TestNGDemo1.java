package com.xiaoyan.day01;
import org.testng.annotations.*;

/**
 * Created by Administrator on 2019/1/6
 */
public class TestNGDemo1 {
    @BeforeTest
    public void beforeTest01(){
        System.out.println("这是@BeforeTest注解");
    }
    @BeforeMethod
    public void beforeMethod01(){
        System.out.println("这是@BeforeMethod注解");
    }
    @Test
    public void testCase1(){
        System.out.println("这是@Test注解,case1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是@Test注解,case2");
    }
    @AfterMethod
    public void afterMethod1(){
        System.out.println("这是@AfterMethod注解");
    }
    @AfterTest
    public void afterTest1(){
        System.out.println("这是@AfterTest注解");
    }
}
