package com.lsf.controller;

import com.lsf.bean.User;
import com.lsf.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2020/2/22.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;



    @GetMapping("getUser")
    public User user() {
        return userService.selectByPrimaryKey(1);
    }
}
