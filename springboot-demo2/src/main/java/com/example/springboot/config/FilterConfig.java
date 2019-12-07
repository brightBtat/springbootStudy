package com.example.springboot.config;

import com.example.springboot.filter.HeFilter;
import com.example.springboot.servlet.HeServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot没有xml,@Configuration可以表示一个spring的xml配置文件
 */
//@Configuration
public class FilterConfig {

    /**
     * 等价于spring配置文件下的bean
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean heServletRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new HeFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
