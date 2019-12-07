package com.it.springboot.controller;

import com.it.springboot.service.impl.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @GetMapping("/boot/index")
    public String index(HttpSession session){
        session.setAttribute("msg","springboot集成Thymeleaf");
        return "index";
    }

    @GetMapping("/boot/user")
    public String user(Model model){
        User user = new User();
        user.setId(1);
        user.setNick("白白");
        user.setPhone("12345678910");
        user.setEmail("2421577892@qq.com");
        user.setAddress("sldkffs");
        model.addAttribute("user",user);

        List<User> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        User[] users = new User[3];

        for (int i = 0; i < 3; i++) {
            User user1 = new User();
            user1.setId(i);
            user1.setNick(i+"-123");
            user1.setPhone(i+"0000");
            user1.setEmail(i+"@qq.com");
            user1.setAddress(i+"address");
            list.add(user1);
            map.put(String.valueOf(i),user1);
            users[i] = user1;
        }
        model.addAttribute("list",list);
        model.addAttribute("map",map);
        model.addAttribute("array",users);

        return "index";
    }

}
