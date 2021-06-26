package com.example.demo.config;

//import com.example..User;
//import com.example.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
/*
public class UserRealm extends AuthorizingRealm {

}*/

    // @Autowired
    // UserService userService;
  /*  @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        return null;
    }
}
       // UsernamePasswordToken token =(UsernamePasswordToken)authenticationToken;
       // User user= userService.selectByUsername(token.getUsername());
       // if(user==null) {
      //      return null;
      //  }
       // return new SimpleAuthenticationInfo(user,user.getPassword(),"");
   // }
//}*/