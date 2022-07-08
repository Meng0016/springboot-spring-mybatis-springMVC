package com.ydlclass;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Configuration
public class A implements InitializingBean, DisposableBean {
    private B b;

    public A() {
    }

    public A(B b) {
        this.b = b;
    }

    public void setB(B b) {
        this.b = b;
    }
    public void init0(){
        System.out.println("xml  init!");

    }
    public void destroy0(){
        System.out.println("destroy init");
    }

    @PostConstruct
    public void init2(){
        System.out.println("annotation  init!");

    }
    @PreDestroy
    public void destroy2(){
        System.out.println("annotation  destroy ");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
