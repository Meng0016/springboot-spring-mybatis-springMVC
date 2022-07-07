package com.example.springbootshiro;

import com.example.springbootshiro.pojo.User;
import com.example.springbootshiro.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.example.springbootshiro.mapper")
class SpringbootShiroApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
        User meng = userService.findByUsername("meng");
        System.out.println(meng);
    }

}
