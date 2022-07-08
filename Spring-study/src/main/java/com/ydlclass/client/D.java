package com.ydlclass.client;

import com.ydlclass.spring.api.*;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ConcurrentHashMap;

public class D implements ApplicationContextAware, BeanFactoryPostProcessor, BeanPostProcessor, init {

    public D() {
        System.out.println("D is created");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println(applicationContext+"------------------------------------setApplicationContext");
    }

    @Override
    public void BeanFactoryPostProcess(ConcurrentHashMap beanFactory) {
        System.out.println(beanFactory+"------------------------beanFactoryPostProcessor");
    }

    @Override
    public void beforeInitializtion(Object bean) {
        System.out.println(bean+"------------------------beforeInitializtion");

    }

    @Override
    public void afterInitializtion(Object bean) {
        System.out.println(bean+"------------------------afterInitializtion");

    }

    @Override
    public void init() {
        System.out.println("d is init");
    }
}
