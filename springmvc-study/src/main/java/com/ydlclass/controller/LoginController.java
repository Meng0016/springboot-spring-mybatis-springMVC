package com.ydlclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("login")
    public String toLogin(){


        return "login";
    }

    @PostMapping("login")
    public String Login(HttpSession session,@RequestParam("username") String username){
        //这个登录逻辑应该有具体的业务层代码进行处理
        session.setAttribute("user",username);
        return "index";
    }

}
