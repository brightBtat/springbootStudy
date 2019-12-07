package com.it.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan(basePackages = "com.it.springboot.mapper")
public class AllPrioviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllPrioviderApplication.class, args);
    }

}
