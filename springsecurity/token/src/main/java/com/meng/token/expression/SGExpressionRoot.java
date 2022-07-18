package com.meng.token.expression;

import com.meng.token.controller.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ex")
public class SGExpressionRoot {
    public boolean hasAuthority(String authority) {
        //获取当前用户的权限、
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        //根据权限判断用户是否有权限访问
        return permissions.contains(authority);

    }
}
