package com.meng.token.service.impl;

import com.meng.token.controller.LoginUser;
import com.meng.token.pojo.User;
import com.meng.token.result.ResponseResult;
import com.meng.token.service.LoginService;
import com.meng.token.utils.JwtUtil;
import com.meng.token.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult login(User user) {
        //Authentication
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);

        //如果认证没通过  给出对应提示信息
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登陆失败");
        }
        //如果认证通过  给出token信息  使用userid生成jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        Map<String,String> map =new HashMap<>();
        map.put("token",jwt);
        //把完整用户信息存入redis userid作为key  存入用户信息
        redisCache.setCacheObject("login:"+userid,loginUser);
        return new ResponseResult(200, "登陆成功", map);
    }

    @Override
    public ResponseResult logout() {
        //获取SecurityContextHolder中的用户信息
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer id = loginUser.getUser().getId();

        //删除redis中的用户信息
        redisCache.deleteObject("login:"+id);

        return new ResponseResult(200, "退出成功");
    }
}
