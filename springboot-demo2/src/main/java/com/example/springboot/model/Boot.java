package com.example.springboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义属性读取类
 */
@Component
@ConfigurationProperties(prefix = "boot")
public class Boot {
    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Boot{" + "name='" + name + '\'' + ", location='" + location + '\'' + '}';
    }
}
