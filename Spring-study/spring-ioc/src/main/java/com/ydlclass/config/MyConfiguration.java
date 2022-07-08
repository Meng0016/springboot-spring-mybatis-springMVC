package com.ydlclass.config;

import com.ydlclass.Adress;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyConfiguration {

    @Bean
    @Qualifier("addr")
    public Adress adress(){
        return new Adress();
    }

    /*@Bean
    public User user(@Qualifier("addr") Adress adress){
        User user=new User();
        user.setAdress(List.of(adress));
        return user;
    }*/
}
