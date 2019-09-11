package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id){

        return userMapper.Sel(id);
    }

    public void insert(User user){
        userMapper.insert(user);
    }

    public PageInfo<User> findAllUser(User user){
        user.setPageNum(1);
        user.setPageSize(5);
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        List<User> list = userMapper.findAllUser(user);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return pageInfo;
    }
}
