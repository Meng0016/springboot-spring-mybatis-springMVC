package com.ydlclass.spring.api.impl;


import com.ydlclass.client.D;
import com.ydlclass.spring.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private ConcurrentHashMap<String,Object> beanFactory ;
    private ConcurrentHashMap<String, BeanFactoryPostProcessor> beanFactoryPostProcessors =new ConcurrentHashMap<>(64);
    private ConcurrentHashMap<String, BeanPostProcessor> beanPostPorcessors= new ConcurrentHashMap<>(64);

    private Properties beanDefinitions =new Properties();

    public ClassPathXmlApplicationContext(String config) {
        InputStream inputStream = readXML(config);

        try {

            //加载Bean定义
            beanDefinitions.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //刷新工厂
        refresh();
    }

    private void refresh() {
        //1.准备环境
        prepareRefresh();
        //2、创建门面
        beanFactory =new ConcurrentHashMap<>(64);
        //3、准备工作
        prepareBeanFactory(beanFactory);
       try{
           postProcessorBeanFactory(beanFactory);

           invokeBeanFactoryPostProcessor(beanFactory);
        //注册所有BeanPostProcessor
           registerBeanPostProcessor(beanFactory);
           //完成实例化
           finishBeanFactoryInitialization(beanFactory);





       }catch (Exception e){
           e.printStackTrace();
       }



    }

    private void finishBeanFactoryInitialization(ConcurrentHashMap<String, Object> beanFactory) {
        for (Map.Entry<Object,Object> entry: beanDefinitions.entrySet()){
            String classname = (String)entry.getValue();
            Constructor<?> declaredConstructor = null;
            try {

                //1、创建
                Class<?> aClass = Class.forName(classname);
                declaredConstructor = aClass.getDeclaredConstructor();
                Object bean = declaredConstructor.newInstance();

                //2、依赖注入 ，属性填充

                //3、init

                if(bean instanceof ApplicationContextAware){
                    ApplicationContextAware applicationContextAware= (ApplicationContextAware)bean;
                    applicationContextAware.setApplicationContext(this);
                }

                //BeforeInit
                for (Map.Entry<String,BeanPostProcessor> entry1:beanPostPorcessors.entrySet()){
                    entry1.getValue().beforeInitializtion(bean);
                }



                if(bean instanceof init){
                   init init= (init)bean;
                   init.init();
                }
                //AfterInit
                for (Map.Entry<String,BeanPostProcessor> entry1:beanPostPorcessors.entrySet()){
                    entry1.getValue().afterInitializtion(bean);
                }
    //4、销毁

                beanFactory.put((String) entry.getKey(),bean);
            } catch (NoSuchMethodException | ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        }


    }

    private void registerBeanPostProcessor(ConcurrentHashMap<String, Object> beanFactory) {
        beanPostPorcessors.put("d",new D());

    }

    private void invokeBeanFactoryPostProcessor(ConcurrentHashMap<String, Object> beanFactory) {
        //1.找到所有BeanFactoryPostProcessor
        for (Map.Entry<String,BeanFactoryPostProcessor> entry: beanFactoryPostProcessors.entrySet()){
            //2.调用方法
            entry.getValue().BeanFactoryPostProcess(beanFactory);

        }
    }

    private void postProcessorBeanFactory(ConcurrentHashMap<String, Object> beanFactory) {

        beanFactoryPostProcessors.put("d", new D());
    }

    private void prepareBeanFactory(ConcurrentHashMap<String, Object> beanFactory) {

        beanFactoryPostProcessors.put("c",new ConfigBeanFactoryPostProcessoe());
    }

    private void prepareRefresh() {
        System.out.println("对环境进行一些检查，日志配置，看是否适合卖蛋糕");
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.get(name);
    }

    @Override
    public InputStream readXML(String config) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(config);
    }
}
