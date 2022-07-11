package com.meng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootFirstApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootFirstApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        System.out.println("SpringbootFirstApplication.main()"+ Arrays.toString(beanDefinitionNames));
    }

}
