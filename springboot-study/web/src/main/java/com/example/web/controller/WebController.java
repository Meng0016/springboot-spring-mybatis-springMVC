package com.example.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping("/123.jpeg")
    public String getHello() {
        return "Hello World!";
    }//返回的是一个字符串 而不是一个图片

}
