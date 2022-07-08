package com.ydlclass;

import org.springframework.beans.factory.annotation.Value;

public class F {
    @Value("${basePath}")
    private String basePath;

    @Override
    public String toString() {
        return "F{" +
                "basePath='" + basePath + '\'' +
                '}';
    }
}
