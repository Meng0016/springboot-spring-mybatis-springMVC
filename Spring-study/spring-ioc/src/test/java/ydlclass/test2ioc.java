package ydlclass;

import com.ydlclass.*;
import com.ydlclass.env.MyPropertySource;
import com.ydlclass.factorybean.DataSourceFactoryBean;
import com.ydlclass.listener.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ydlclass.service.OrderService;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import javax.sql.DataSource;

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

    @Test
    public void testFactoryBean1(){
        ApplicationContext context=new AnnotationConfigApplicationContext(DataSourceFactoryBean.class);
        DataSourceFactoryBean bean= (DataSourceFactoryBean) context.getBean("&dataSourceFactoryBean");
        System.out.println(bean);
    }
    @Test
    public void testFactoryBean0(){
        ApplicationContext context=new AnnotationConfigApplicationContext(DataSourceFactoryBean.class);
        DataSource bean=  context.getBean(DataSource.class);
        System.out.println(bean);
    }
    @Test
    public void testProfile() {
        //创建容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //激活环境
        context.getEnvironment().setActiveProfiles("prod");
        //扫包
        context.scan("com.ydlclass.datasource");
        //刷新
        context.refresh();
        //使用
        DataSource bean = context.getBean(DataSource.class);
        logger.info("{}", bean);

    }
    @Test
    public void testenv() {
        //创建容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new MyPropertySource("my"));
        context.refresh();
        //使用
        String hello =environment.getProperty("hello");
        logger.info(hello);
        String property =environment.getProperty("os.name");
        System.out.println(property);


    }
    @Test
    public void testValue() {
        //创建容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class,F.class);
        MyConfig myConfig=context.getBean(MyConfig.class);
        F f=context.getBean(F.class);
        System.out.println(myConfig);
        System.out.println(f);

    }
    @Test
    public void testListener() {
        //创建容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageListener.class, EmailListener.class, EmailListener2.class,ContextFinish.class);
        context.publishEvent(new OrderEvent(new Order("lucy","122")));

    }

}
