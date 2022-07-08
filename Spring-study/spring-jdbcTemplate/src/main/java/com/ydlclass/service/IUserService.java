package com.ydlclass.service;

import com.ydlclass.entity.User;

import java.util.List;

public interface IUserService {
    User selectById(int id);
     List<User> select();
}
