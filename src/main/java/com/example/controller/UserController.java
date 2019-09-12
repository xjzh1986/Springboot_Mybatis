package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.User;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String GetUser(){
        userService.Sel(1).toString();
        return "/index";
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public PageInfo<User> selectAll(@RequestParam("page") int page,User user){
        PageInfo<User> pageInfo = userService.findAllUser(page,user);
        // 用户组对象转JSON串
        String jsonString = JSON.toJSONString(pageInfo);
        System.out.println("jsonString:" + jsonString);
        return pageInfo;
    }
}
