package com.example.controller;

import com.example.Constants.PermissionConstants;
import com.example.entity.User;
import com.example.interceptor.RequiredPermission;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "跳转首页" ,  notes="跳转首页")
    @RequestMapping(value="/index",method= RequestMethod.GET)
    @RequiredPermission(PermissionConstants.ADMIN_PRODUCT_LIST) // 权限注解
    public String index(){
        return "/table_foo_table";
    }

    @ApiOperation(value = "登录" ,  notes="登录")
    @RequestMapping(value="/doLogin",method= RequestMethod.GET)
    public String login(User user){
        return "/index";
    }
}
