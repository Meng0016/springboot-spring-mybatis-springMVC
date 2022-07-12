package com.example.springbootshiro.service;

import com.example.springbootshiro.mapper.UserMapper;
import com.example.springbootshiro.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //@Lazy
    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
