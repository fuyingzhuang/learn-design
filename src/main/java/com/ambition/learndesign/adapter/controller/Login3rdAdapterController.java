package com.ambition.learndesign.adapter.controller;

import com.ambition.learndesign.adapter.Login3rdTarget;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ambition
 * @date 2023/11/23 17:41
 */
@RestController
@RequestMapping("/login3rd")
public class Login3rdAdapterController {

    @Resource
    private Login3rdTarget login3rdTarget;

    @RequestMapping("/loginByGitee")
    public String loginByGitee(String code, String state) {
        return login3rdTarget.loginByGitee(code, state);
    }

}
