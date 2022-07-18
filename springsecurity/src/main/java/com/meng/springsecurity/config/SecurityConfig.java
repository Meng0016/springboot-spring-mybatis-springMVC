package com.meng.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //配置登录成功的处理器
                .successHandler(successHandler)
                //配置登录失败的处理器
                .failureHandler(failureHandler);

        http.authorizeRequests().anyRequest().authenticated();

        http.logout()
//                .logoutSuccessHandler((request, response, authentication) -> {
//                    response.setContentType("application/json;charset=utf-8");
//                    response.getWriter().write("{\"code\":0,\"msg\":\"退出成功\"}");
//                });
                .logoutSuccessHandler(logoutSuccessHandler);
    }
}
