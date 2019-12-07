package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试jsp页面
 */
@Controller
public class TestMvcController {
    @GetMapping("/boot/jsp")
    public String jsp() {
        return "test";
    }
}
