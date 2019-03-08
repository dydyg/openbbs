package com.hc.openbbs.config;

import com.hc.openbbs.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yg
 * @create 2018-01-10 11:18
 * @desc web配置类：1、登陆拦截器配置
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        *//**
         * 拦截访问路径：/admin/**.排除/admin、/admin/login
         *//*
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/types");
        super.addInterceptors(registry);
    }*/
}
