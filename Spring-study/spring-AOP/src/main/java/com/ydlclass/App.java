package com.ydlclass;

import com.ydlclass.config.AppConfig;
import com.ydlclass.service.IActivity;
import com.ydlclass.service.IOrderService;
import com.ydlclass.service.IUserService;
import com.ydlclass.service.impl.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("--------------------");
        IOrderService orderService=context.getBean(IOrderService.class);
        String order= orderService.order(1000);
        System.out.println(order);


        IUserService userService = context.getBean(IUserService.class);
        userService.register();

        IActivity bean=context.getBean(IActivity.class);
        bean.sendGift();
    }
}
