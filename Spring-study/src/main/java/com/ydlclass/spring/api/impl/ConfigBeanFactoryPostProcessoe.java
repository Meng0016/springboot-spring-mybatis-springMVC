package com.ydlclass.spring.api.impl;

import com.ydlclass.spring.api.BeanFactoryPostProcessor;

import java.util.concurrent.ConcurrentHashMap;

public class ConfigBeanFactoryPostProcessoe implements BeanFactoryPostProcessor {
    @Override
    public void BeanFactoryPostProcess(ConcurrentHashMap beanFactory) {
        System.out.println("正在解析注解！！！");
    }
}
