package com.ydlclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping("/test1")
    @ResponseBody
    public ModelAndView test1(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","hello test1");
        mv.setViewName("hello");
        return mv;
    }
}
