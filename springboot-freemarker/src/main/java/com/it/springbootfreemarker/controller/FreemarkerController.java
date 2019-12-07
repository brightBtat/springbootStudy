package com.it.springbootfreemarker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FreemarkerController {
    /**
     * 日志管理
     */
    private static Logger log = LoggerFactory.getLogger(FreemarkerController.class);

    @RequestMapping("/freemarker")
    public String freemarker(Model model) {
        log.info("====>>输出模板引擎");
        //model.addAttribute("word", "laji");
        return "flt/free";
    }
}
