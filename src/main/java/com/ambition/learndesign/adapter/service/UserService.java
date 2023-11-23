package com.ambition.learndesign.adapter.service;

import com.ambition.learndesign.adapter.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ambition
 * @since 2023-11-22
 */
public interface UserService extends IService<User> {


    String login(String userName, String password);

    String register(String userName, String password);
}
