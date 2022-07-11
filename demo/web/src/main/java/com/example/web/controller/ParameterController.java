package com.example.web.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader Map<String,String> headers,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("hobbies") List<String> hobbies,
                                     @RequestParam Map<String,String> params
                                    // @CookieValue Cookie cookie
    ){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",username);
        map.put("pv",pv);
        map.put("headers",headers);
        map.put("age",age);
        map.put("hobbies",hobbies);
        map.put("params",params);
//        System.out.println(cookie);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
    //矩阵变量
    @GetMapping("/cars/{path}")
    public Map carsell(@MatrixVariable("low") Integer low
            ,@MatrixVariable("brand") List<String> brand
    ,@MatrixVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

}
