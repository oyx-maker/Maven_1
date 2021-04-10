package com.yc;

import Junit.*;
import org.junit.Assert;

//测试用例类
public class MyCaculateTest {
    private  Calculate cal;//待测试的单元
    @BeforeClass
    //执行测试方法前调用
    public void bc() throws Exception {
        System.out.println("beforeclass");


    }
    @AfterClass
    //执行测试方法前调用
    public void ac() throws Exception {
        System.out.println("Afterclass");


    }
    @MyBefore
    //执行测试方法前调用
    public void setUp() throws Exception {
        System.out.println("before");
        cal=new Calculate();

    }

    @MyAfter                  //执行测试方法后调用
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @MyTest
    public void add() {
        Assert.assertEquals(3,cal.add(1,2));

    }

    @MyTest
    public void sub() {
        Assert.assertEquals(1,cal.sub(2,1));
    }
}