package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/meng")
    public String index(Model model) {
        model.addAttribute("msg", "Hello Thymeleaf!");
        model.addAttribute("link","https://www.baidu.com");
        return "success";
    }

}
