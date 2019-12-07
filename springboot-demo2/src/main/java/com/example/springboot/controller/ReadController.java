package com.example.springboot.controller;

import com.example.springboot.model.Boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取配置文件下自定义属性
 */
@RestController //相当于@Controller + @ResponseBody
public class ReadController {

    @Value("${boot.name}")
    private String name;

    @Value("${boot.location}")
    private String location;

    @Autowired
    private Boot boot;

    @GetMapping("/boot/read")
    public String writeTest() {
        //@Value()方式读取自定义配置
        System.out.println("name:" + name);
        System.out.println("location:" + location);

        //@ConfigurationProperties的方式读取自定义配置
        return boot.getName() + " -- " + boot.getLocation();
    }


}
