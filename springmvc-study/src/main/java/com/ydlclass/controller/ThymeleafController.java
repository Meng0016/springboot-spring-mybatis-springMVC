package com.ydlclass.controller;

import com.ydlclass.entity.po.UserPo;
import com.ydlclass.entity.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ThymeleafController {

    @GetMapping("index")
    public String index(Model model){

        model.addAttribute("msg","hello Thymeleaf");
        model.addAttribute("aaa","你好");
       /* model.addAttribute("users", List.of(new UserPo("tom","2134"),new UserPo("sdasd","1243435")
        ,new UserPo("你好","66666")));*/
        return "index";
    }
}
