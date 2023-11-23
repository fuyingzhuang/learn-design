package com.ambition.learndesign.adapter.mapper;

import com.ambition.learndesign.adapter.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ambition
 * @since 2023-11-22
 */
public interface UserMapper extends BaseMapper<User> {


    String login(@Param("userName") String userName, @Param("password") String password);

    String register(@Param("userName") String userName, @Param("password") String password);

}
