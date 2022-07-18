package com.meng.token.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @RequestMapping("/hello")
    @PreAuthorize("hasAnyAuthority('system:dept:list','test')") //拥有test权限才能访问
    public String hello() {
        return "Hello Token";
    }

    @RequestMapping("/hello1")
    @PreAuthorize("@ex.hasAuthority('system:dept:list')") //拥有test权限才能访问
    public String hello1() {
        return "Hello Token1";
    }

}


