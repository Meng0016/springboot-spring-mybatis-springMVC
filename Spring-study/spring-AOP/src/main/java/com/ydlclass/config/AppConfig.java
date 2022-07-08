package com.ydlclass.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan("com.ydlclass")
@EnableAspectJAutoProxy
public class AppConfig {
}
