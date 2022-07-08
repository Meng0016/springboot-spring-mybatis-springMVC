package com.ydlclass.service.impl;

import com.ydlclass.dao.IUserDao;
import com.ydlclass.entity.User;
import com.ydlclass.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }
    public List<User> select(){
        return userDao.select();
    }
}
