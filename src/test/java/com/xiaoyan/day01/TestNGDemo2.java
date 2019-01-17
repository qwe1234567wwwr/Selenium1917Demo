package com.xiaoyan.day01;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by Administrator on 2019/1/6
 */
public class TestNGDemo2 {
    //校验a==a

    /**
     * 假如我用A账号B密码登录
     * 那么我登录成功
     * 我打开xxx页面，点击xxx删除，那么我删除成功
     */
    @Test
    public void assertEqualsTest(){
        String a ="adfsd";
        String b ="adfsd111";
        System.out.println("登录");
        Assert.assertEquals(a,b,"校验登录成功");
        System.out.println("操作打开页面删除");
        Assert.assertEquals(a,b,"删除成功");
    }
    @Test
    public void assertNotEqualsTest(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b);
    }
    @Test
    public void assertNullTest(){
        String a = null;
        Assert.assertNull(a);
    }
    @Test
    public void assertNotNullTest(){
        String a =null;
        Assert.assertNotNull(a);
    }
    @Test
    public void a(){
        Boolean a =false;
        Assert.assertFalse(a);
    }

}
