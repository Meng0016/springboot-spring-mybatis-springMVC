package com.ydlclass.api;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {

    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("app-context.xml");
    }
}
