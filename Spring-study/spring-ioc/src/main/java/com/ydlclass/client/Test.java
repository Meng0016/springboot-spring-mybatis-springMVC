package com.ydlclass.client;

import com.ydlclass.spring.api.ApplicationContext;
import com.ydlclass.spring.api.impl.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
       ApplicationContext applicationContext=new  ClassPathXmlApplicationContext("beans.properties");
        Object d = applicationContext.getBean("c");
        System.out.println(d);
    }
}
