package com.ydlclass;

import com.ydlclass.config.AppConfig;
import com.ydlclass.service.IActivity;
import com.ydlclass.service.IOrderService;
import com.ydlclass.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppByXml {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("aop.xml");
        IOrderService bean = context.getBean(IOrderService.class);
        bean.order(1000);


    }
}
