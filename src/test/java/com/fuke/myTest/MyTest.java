package com.fuke.myTest;

import com.fuke.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class MyTest {

    @Test
    public void test1(){
        System.out.println("测试1");
        Assert.assertEquals(1,1);
    }
    @Before
    public void before(){
        System.out.println("前置方法");
    }
    @Test
    public void test2(){
        System.out.println("测试2");
    }
    @After
    public void after(){
        System.out.println("后置方法");
    }
}
