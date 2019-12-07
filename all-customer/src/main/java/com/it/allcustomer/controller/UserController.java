package com.it.allcustomer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.it.springboot.model.User;
import com.it.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/index")
    public String index(@RequestParam(value = "curPage",defaultValue = "1")Integer curPage
                        , Model model){

        int pageSize = 5;

        //分页
        int totalRows = userService.getUserByTotal();

        //计算分页
        int totalPage = (int)Math.ceil(totalRows*1.0 / pageSize);

        if(curPage < 1){
            curPage = 1;
        }
        if(curPage > totalPage){
            curPage = totalPage;
        }

        int startRow = (curPage - 1)*pageSize;
        Map<String,Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("startRow",startRow);
        paramMap.put("pageSize",pageSize);

        List<User> list = userService.getUserByPage(paramMap);
        model.addAttribute("list",list);
        model.addAttribute("curPage",curPage);
        model.addAttribute("totalPage",totalPage);
        return "index";
    }

    @GetMapping("/user/addUserUI")
    public String addUserUI(){
        return "addUser";
    }

    @PostMapping("/user/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/index";
    }

    @GetMapping("/user/toUpdateUserUI")
    public String toUpdateUserUI(Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }

    @PostMapping("/user/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/index";
    }

    @GetMapping("/user/deleteUser")
    public String deleteUser(Integer id){
        userService.deleteUser(id);
        return "redirect:/index";
    }
}
