package com.ydlclass;

import com.ydlclass.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void testTransfer(){
        ApplicationContext context=new ClassPathXmlApplicationContext("transcation.xml");
        IAccountService accountService=context.getBean(IAccountService.class);
        accountService.transfer2("tom","lucy",100);
    }
    @Test
    public void testTransfer2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("tx.xml");
        IAccountService accountService=context.getBean(IAccountService.class);
        accountService.transfer2("tom","lucy",100);
    }
    @Test
    public void testTransfer3(){
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        IAccountService accountService=context.getBean(IAccountService.class);
        accountService.transfer2("tom","lucy",100);
    }
}
