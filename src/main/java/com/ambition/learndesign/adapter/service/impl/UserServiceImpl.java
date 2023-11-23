package com.ambition.learndesign.adapter.service.impl;

import com.ambition.learndesign.adapter.mapper.UserMapper;
import com.ambition.learndesign.adapter.model.entity.User;
import com.ambition.learndesign.adapter.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ambition
 * @since 2023-11-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public String login(String userName, String password) {
        return userMapper.login(userName, password);
    }

    @Override
    public String register(String userName, String password) {
        return userMapper.register(userName, password);
    }
}
