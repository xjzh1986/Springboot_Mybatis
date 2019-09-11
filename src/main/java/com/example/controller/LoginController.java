package com.example.controller;

import com.example.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/index")
    public String index(){

        return "/table_foo_table";
    }

    @RequestMapping("/doLogin")
    public String login(User user){
        return "/index";
    }
}
