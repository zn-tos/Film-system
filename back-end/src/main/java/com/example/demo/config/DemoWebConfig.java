package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DemoWebConfig implements WebMvcConfigurer {

    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
    /*    registry.addInterceptor(new com.example.demo.config.LoginInterceptor())
                .addPathPatterns("/**")
                //放行路径，可以添加多个
                .excludePathPatterns("/login","/register","/manage/**","/upload");
    }*/
    }
}