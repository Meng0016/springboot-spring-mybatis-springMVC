package com.meng.controller;

import com.meng.pojo.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Pet pet;

    @RequestMapping("/hello")
    public String hello() {

        return "Hello Spring Boot!";
    }

    @RequestMapping("/pet")
    public String pet() {
        Pet pet = new Pet();
        return pet.toString();
    }
}
