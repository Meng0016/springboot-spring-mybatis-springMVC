package com.ydlclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class CommonConfiguartion {


    //等同于配置文件里的视图解析器
    // 都可
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/page/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
