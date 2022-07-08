package com.ydlclass.spring.api;

import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactoryPostProcessor {
    void BeanFactoryPostProcess(ConcurrentHashMap beanFactory);
}
