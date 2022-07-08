package com.ydlclass;

import com.ydlclass.service.OrderService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test2ioc {
    private static final Logger logger = LoggerFactory.getLogger(test2ioc.class);
    @Test
    public void testioc(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        UserDao userDao =context.getBean(UserDao.class);
        userDao.hello();
        //也可以用name拿 getBean("userDao")
        UserDao userDao1=(UserDao) context.getBean("userDao");
        userDao1.hello();

    }
    @Test
    public void testStaticFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService= (UserService) context.getBean("userService");
        logger.info(userService.toString());
        /*userService.hello();*/

        /*UserService userService1 =new UserService();
        userService1.setUserDao(new UserDao());
        userService.hello();*/
    }
    @Test
    public void testConstructor(){
        ApplicationContext context =new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService =(UserService) context.getBean("userService");
        userService.hello();
    }
    @Test
    public void testUser(){
        ApplicationContext context =new ClassPathXmlApplicationContext("ioc.xml");
        User user =context.getBean(User.class);
        logger.info(user.toString());
    }
    @Test
    public void testautowired(){
        ApplicationContext context =new ClassPathXmlApplicationContext("autowired.xml");
        User user =context.getBean(User.class);
        User user1 =context.getBean(User.class);


        logger.info(user.toString());
        logger.info(user1.toString());
        logger.info("{}",user==user1);
    }
    @Test
    public void testcycle(){
        ApplicationContext context =new ClassPathXmlApplicationContext("cycle.xml");
        A a=context.getBean(A.class);
        A a1=context.getBean(A.class);
        logger.info(a.toString());
        logger.info(a1.toString());
        logger.info("{}",a==a1);
        B b=context.getBean(B.class);
        logger.info(b.toString());
    }
    @Test
    public void testlifecycle(){
        ApplicationContext context =new ClassPathXmlApplicationContext("lifecycle.xml");
        Adress adress=context.getBean(Adress.class);
        logger.info("{}",adress);
    }

    @Test
    public void testlifecycle2(){
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("lifecycle.xml");
       /* Adress adress=context.getBean(Adress.class);*/
        A a =context.getBean(A.class);
     /*   logger.info("{}",adress);*/
        logger.info("{}",a);
        context.close();
    }

    @Test
    public void testScan() {
        ApplicationContext context = new ClassPathXmlApplicationContext("scan.xml");
        OrderService orderService = context.getBean(OrderService.class);
        logger.info("{}", orderService);

    }
    @Test
    public void testScan2() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ydlclass");
        OrderService orderService = context.getBean(OrderService.class);
        logger.info("{}", orderService);

    }

}
