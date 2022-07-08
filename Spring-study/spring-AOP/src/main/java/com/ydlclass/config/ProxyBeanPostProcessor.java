package com.ydlclass.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        try {
                            Object invoke = method.invoke(bean, args);
                            System.out.println("提交事务");
                            return invoke;
                        } catch (RuntimeException runtimeException) {
                            System.out.println("回滚");
                            throw new RuntimeException("异常");
                        }
                    }
                });

        return proxy;
    }
}
