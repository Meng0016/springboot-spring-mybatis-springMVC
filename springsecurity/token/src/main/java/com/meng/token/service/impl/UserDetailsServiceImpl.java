package com.meng.token.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meng.token.controller.LoginUser;
import com.meng.token.mapper.MenuMapper;
import com.meng.token.mapper.UserMapper;
import com.meng.token.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", username);
        User user = userMapper.selectOne(queryWrapper);
        //判断用户是否存在
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名密码错误");
        }
        // TODO 查询对应权限信息
//        List<String> list =new ArrayList<>(Arrays.asList("test","admin"));
        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        //把用户数据封装成UserDetails返回

        return new LoginUser(user,list);
    }


}

