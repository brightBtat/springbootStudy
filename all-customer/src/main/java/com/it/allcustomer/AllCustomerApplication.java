package com.it.allcustomer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class AllCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllCustomerApplication.class, args);
    }

}
