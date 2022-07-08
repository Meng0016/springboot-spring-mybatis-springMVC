package com.ydlclass;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Adress implements InitializingBean, DisposableBean {

    private String name;

    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }

    public  Adress(){
        System.out.println("address is create");
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
