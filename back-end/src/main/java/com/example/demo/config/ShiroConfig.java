package com.example.demo.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
public class ShiroConfig {

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);

        //bean.setLoginUrl("/tologin");//提供登录到url
        //bean.setSuccessUrl("/index");//提供登陆成功的url
        //bean.setUnauthorizedUrl("/unauthorized");

        /*
         * 可以看DefaultFilter,这是一个枚举类，定义了很多的拦截器authc,anon等分别有对应的拦截器
         * */
        /*
        filterChainDefinitionMap.put("/index", "authc");//代表着前面的url路径，用后面指定的拦截器进行拦截
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/loginUser", "anon");
        filterChainDefinitionMap.put("/admin", "roles[admin]");//admin的url，要用角色是admin的才可以登录,对应的拦截器是RolesAuthorizationFilter
        filterChainDefinitionMap.put("/edit", "perms[edit]");//拥有edit权限的用户才有资格去访问
        filterChainDefinitionMap.put("/druid/**", "anon");//所有的druid请求，不需要拦截，anon对应的拦截器不会进行拦截
        filterChainDefinitionMap.put("/**", "user");//所有的路径都拦截，被UserFilter拦截，这里会判断用户有没有登陆
        */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        //filterMap.put("/add","authc");
        //filterMap.put("/add","perms[add]");
        //filterMap.put("/update","authc");
        bean.setFilterChainDefinitionMap(filterMap);//设置一个拦截器链

        return bean;
    }


    /*
     * 注入一个securityManager
     * 原本以前我们是可以通过ini配置文件完成的，代码如下：
     *  1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
     * */
    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("managerRealm") com.example.demo.config.ManagerRealm managerRealm) {
        //这个DefaultWebSecurityManager构造函数,会对Subject，realm等进行基本的参数注入
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        List<Realm> realms=new ArrayList<>();
        //realms.add(userRealm);
       realms.add(managerRealm);
        manager.setRealms(realms);//往SecurityManager中注入Realm，代替原本的默认配置
        return manager;
    }

    //自定义的Realm
  //  @Bean("userRealm")
   // public com.example.demo.config.UserRealm userRealm() {
     //   return new com.example.demo.config.UserRealm();
   // }
    @Bean("managerRealm")
    public com.example.demo.config.ManagerRealm managerRealm() {
        return new com.example.demo.config.ManagerRealm();
    }
}
