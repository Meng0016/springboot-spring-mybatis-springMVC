package com.meng.token.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CrossConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 允许跨域访问的路径
                .allowedOrigins("*")
                // 允许跨域访问的域名
                .allowedMethods("*")
                // 允许跨域访问的方法
                .allowedHeaders("*")
                // 允许跨域访问的头信息
                .allowCredentials(true)
                // 是否允许证书 不需要配置
                .maxAge(3600);
    }
}

