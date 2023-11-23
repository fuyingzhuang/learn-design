package com.ambition.learndesign.adapter;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Ambition
 * @desc 第三方登陆接口 在此接口中定义第三方登陆的方法 比如微信登陆，QQ登陆，Gitee登陆等
 * @since 2023-11-22
 */

public interface Login3rdTarget {
    public String loginByGitee(String code, String state);

    public String loginByWechat(String... params);

    public String loginByQQ(String... params);
}
