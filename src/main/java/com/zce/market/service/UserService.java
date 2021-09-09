package com.zce.market.service;

import com.zce.market.pojo.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.Map;

/**
 * 关于用户的一些业务操作
 * creator：Administrator
 * date:2019/12/17
 */
public interface UserService {
    /**
     * 登录方法，如果登录成功，返回true，登录失败返回false
     *
     * @param user
     * @return
     */
    boolean login(User user);

    /**
     *
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    Map<String, Object> register(User user);

    String adduser(User user);

    String getUserName(String name);
}
