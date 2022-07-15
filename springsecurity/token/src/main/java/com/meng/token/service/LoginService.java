package com.meng.token.service;

import com.meng.token.pojo.User;
import com.meng.token.result.ResponseResult;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
