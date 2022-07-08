package com.ydlclass.spring.api;

public interface BeanPostProcessor {
    void beforeInitializtion(Object bean);
    void afterInitializtion(Object bean);


}
