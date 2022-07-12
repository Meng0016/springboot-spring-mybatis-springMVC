package com.ydlclass.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class hello implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // ModelAndView 封装了模型和视图
        ModelAndView mv = new ModelAndView();
        // 模型里封装数据
        mv.addObject("hellomvc","Hello springMVC!");
        // 封装跳转的视图名字
        mv.setViewName("hello");
        // 不是有个视图解析器吗？
        // 这玩意可以自动给你加个前缀后缀，可以将hellomvc拼装成/jsp/hellomvc.jsp
        return mv;
    }
}
