package com.ydlclass.spring.api;

public interface BeanFactory {
    //通过名字获取Bean
    Object getBean(String name);
}
