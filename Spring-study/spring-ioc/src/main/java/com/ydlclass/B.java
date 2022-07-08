package com.ydlclass;

import org.springframework.context.annotation.Configuration;

@Configuration
public class B {

    private A a;

    public B(A a) {
        this.a = a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
