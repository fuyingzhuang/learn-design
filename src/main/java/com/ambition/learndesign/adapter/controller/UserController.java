package com.ambition.learndesign.adapter.controller;


import com.ambition.learndesign.adapter.Login3rdTarget;
import com.ambition.learndesign.adapter.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Ambition
 * @since 2023-11-22
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(String userName, String password) {
        return userService.login(userName, password);
    }

    @PostMapping("/register")
    public String register(String userName, String password) {
        return userService.register(userName, password);
    }


}

