package com.example.thymeleaf.controller;

import com.example.thymeleaf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 登录页
     * */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String main(User user, HttpSession session, Model model) {
        if (!StringUtils.isEmpty(user.getUsername()) && "123456".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);
            //重定向到主页
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping(value = "/main.html")
    public String mainPage(HttpSession session,Model model) {
        //是否登录
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请先登录");
            return "login";
        }
    }

}
