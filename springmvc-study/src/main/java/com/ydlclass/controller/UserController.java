package com.ydlclass.controller;

import com.alibaba.fastjson.JSONArray;
import com.ydlclass.entity.po.UserPo;
import com.ydlclass.entity.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

    /*@RequestMapping("/hello2")
    public String hello(Model model) throws Exception {
        model.addAttribute("msg","hello model");
        return "redirect:https://www.baidu.com";
    }*/

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String user(Model model){
        model.addAttribute("user","tom");
        return "user";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody

    public String add(Model model){
        model.addAttribute("user","add user");
        return "user";

    }
/*
    @GetMapping(value = "get")
    public String user2(Model model){
        model.addAttribute("user","tom");
        return "user";
    }
    @PutMapping
    @DeleteMapping
    @PostMapping
*/

    @GetMapping(value = "getAll",produces = "application/json;charset=utf-8")
    //返回值直接进入响应体 不走视图解析器
    @ResponseBody
    public String getAll(){

        List<UserPo> users = List.of(new UserPo("tom", "123"),
                new UserPo("jerry", "234"));

        return JSONArray.toJSONString(users);

    }

    @GetMapping(value = "getAll2")
    //返回值直接进入响应体 不走视图解析器
    @ResponseBody
    public List<UserPo> getAll2(){

        List<UserPo> users = List.of(new UserPo("tom", "123"),
                new UserPo("jerry", null));

        return users;

    }

    @GetMapping("getDate")
    @ResponseBody
    public Date getDate(){
        return new Date();
    }

    @PostMapping("insertUser")
    public  String insertUser(@RequestBody UserVo user){
        System.out.println(user);
        return "user";
    }

    @PostMapping("insert")
    public String insert(@Validated UserVo user, BindingResult br){
        List<ObjectError> allErrors = br.getAllErrors();
        Iterator<ObjectError> iterator = allErrors.iterator();
        //打印错误结果
        while (iterator.hasNext()){
            ObjectError error = iterator.next();
            log.error("user数据校验失败:",error.getDefaultMessage());
        }
        if (allErrors.size()>0){
            return "error";
        }
        System.out.println(user);
        return "user";
    }
}
