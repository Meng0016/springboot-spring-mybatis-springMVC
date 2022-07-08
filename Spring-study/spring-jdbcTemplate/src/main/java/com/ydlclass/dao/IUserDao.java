package com.ydlclass.dao;

import com.ydlclass.entity.User;

import java.util.List;

public interface IUserDao {
    //根据id查询
    User selectById(int id);
    List<User> select();

}
