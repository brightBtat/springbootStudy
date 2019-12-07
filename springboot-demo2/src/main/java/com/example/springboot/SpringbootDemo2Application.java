package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.example.springboot.mapper")  //扫描mapper文件
@EnableTransactionManagement //开启事务注解
@ServletComponentScan(basePackages = {"com.it.springboot.servlet", "com.it.springboot.filter"})  //扫描servlet
public class SpringbootDemo2Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootDemo2Application.class, args);
    }

}
