package com.ambition.learndesign.adapter;

import com.alibaba.fastjson.JSONObject;
import com.ambition.learndesign.adapter.model.entity.User;
import com.ambition.learndesign.adapter.service.impl.UserServiceImpl;
import com.ambition.learndesign.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * 适配器模式
 * 继承了 UserServiceImpl，实现了 Login3rdTarget 接口
 * 继承了 UserServiceImpl，可以直接调用 UserServiceImpl 中的方法
 * 实现了 Login3rdTarget 接口，可以重写 Login3rdTarget 接口中的方法
 */
@Service
public class Login3rdAdapter extends UserServiceImpl implements Login3rdTarget {

    /**
     * 从配置文件中读取配置
     * 采用第三方登录的平台 所需要的配置（简单模拟）
     */
    @Value("${gitee.state}")
    private String giteeState;

    @Value("${gitee.token.url}")
    private String giteeTokenUrl;

    @Value("${gitee.user.url}")
    private String giteeUserUrl;

    @Value("${gitee.user.prefix}")
    private String giteeUserPrefix;

    @Override
    public String loginByGitee(String code, String state) {
        //进行state判断，state的值是前端与后端商定好的，前端将State传给Gitee平台，Gitee平台回传state给回调接口
        if (!giteeState.equals(state)) {
            throw new UnsupportedOperationException("Invalid state!");
        }

        //请求Gitee平台获取token，并携带code
        String tokenUrl = giteeTokenUrl.concat(code);
        JSONObject tokenResponse = HttpClientUtils.execute(tokenUrl, HttpMethod.POST);
        String token = String.valueOf(tokenResponse.get("access_token"));
        System.out.println(token);
        //请求用户信息，并携带 token
        String userUrl = giteeUserUrl.concat(token);
        JSONObject userInfoResponse = HttpClientUtils.execute(userUrl, HttpMethod.GET);

        //获取用户信息，userName添加前缀 Gitee@, 密码保持与userName一致。（不同第三方登陆对用户名添加不同的前缀 比如Gitee@Username）
        String userName = giteeUserPrefix.concat(String.valueOf(userInfoResponse.get("name")));
        String password = "your_password";

        //"自动注册" 和登录功能，此处体现了方法的 "复用"
        return autoRegister3rdAndLogin(userName, password);
    }

    private String autoRegister3rdAndLogin(String userName, String password) {
//        如果第三方账号已经登录过,直接进行登录 如果是首次使用的话 就进行注册（用户是无感知的）
//        if (super.checkUserExists(userName)) {
//            return super.login(userName, password);
//        }
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(password);

        //如果第三方账号是第一次登录，先进行自动注册
        super.register(userName, password);
        //自动注册完成后，进行登录
        return super.login(userName, password);
    }

    @Override
    public String loginByWechat(String... params) {
        // 第三方微信登录逻辑
        return null;
    }

    @Override
    public String loginByQQ(String... params) {
        // 第三方QQ登录逻辑
        return null;
    }

}
