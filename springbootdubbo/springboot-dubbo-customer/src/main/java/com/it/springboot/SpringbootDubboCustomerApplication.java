package com.it.springboot;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfig
public class SpringbootDubboCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboCustomerApplication.class, args);
    }

}
