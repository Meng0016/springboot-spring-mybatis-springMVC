package com.meng.token;

import com.meng.token.mapper.UserMapper;
import com.meng.token.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class TokenApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    void TestBCryptpassword() {
        //$2a$10$Zk84xL8wZnA628Weo.aLZua.mV/LChfRudTkG2uhe1z2w4SgvNy5G

        System.out.println(passwordEncoder.matches("123456", "$2a$10$Zk84xL8wZnA628Weo.aLZua.mV/LChfRudTkG2uhe1z2w4SgvNy5G"));
//        String encode=passwordEncoder.encode("123456");
//        String encode1 = passwordEncoder.encode("123456");
//        System.out.println(encode);
//        System.out.println(encode1);
    }

    @Test
    void getUserList() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
