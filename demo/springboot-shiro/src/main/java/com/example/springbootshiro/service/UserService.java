package com.example.springbootshiro.service;

import com.example.springbootshiro.pojo.User;

public interface UserService {

    public User findByUsername(String username);
}
