package com.example.springboot.config;

import com.example.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //需要拦截的路径
        String[] addPathPartterns = {"/boot/**"};

        //不需要的拦截路径
        String[] excludePathPatterns = {"/boot/read", "/boot/jsp", "/myServlet", "/heServlet", "/myFilter", "/heFilter"};

        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor()).addPathPatterns().excludePathPatterns();
    }
}

