package com.ydlclass;

import org.springframework.beans.factory.annotation.Value;

public class User {
    @Value("#{'lucy'}")
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
