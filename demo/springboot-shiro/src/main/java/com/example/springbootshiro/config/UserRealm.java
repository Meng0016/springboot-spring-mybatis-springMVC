package com.example.springbootshiro.config;

import com.example.springbootshiro.pojo.User;
import com.example.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->UserRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");

        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        info.addStringPermission(currentUser.getPerms());
        return info;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("验证-->UserRealm.doGetAuthenticationInfo()");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByUsername(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser", user);
        //可以加密  MD5 盐值加密
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
