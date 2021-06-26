package com.example.demo.config;

import com.example.demo.entity.Manager;
import com.example.demo.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerRealm extends AuthorizingRealm {
    @Autowired
    ManagerService managerService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
        info.addStringPermission("manager:add");
        /*
        Subject subject= SecurityUtils.getSubject();
        User currentUser=(User) subject.getPrincipal();
        info.addStringPermission(currentUser.get);
         */
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");

        UsernamePasswordToken token =(UsernamePasswordToken)authenticationToken;
        Manager manager= managerService.selectByUsername(token.getUsername());
        if(manager==null) {
            return null;
        }
        return new SimpleAuthenticationInfo(manager,manager.getPassword(),"");
    }
}
