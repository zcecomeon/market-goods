package com.zce.market.service.impl;

import com.zce.market.dao.UserDao;
import com.zce.market.pojo.entity.User;
import com.zce.market.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 16:23
 */

@Service // 交给springIOC(容器管理)后边就可以直接自动装配使用它了
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;


    @Override
    public boolean login(User user) {
        User dbUser = userDao.selectByPhone(user.getPhone());
        if (dbUser == null) {// 数据库里边都没有这个人，直接登录失败
            return false;
        } else {
            if (user.getPassword() == null) {// 如果传递过来的密码为null,直接登录失败
                return false;
            }
            if (user.getPassword().equals(dbUser.getPassword())) {// 如果传过来的密码，等于我查询的密码， 就表示登录成功！


                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserByPhone(String phone) {
        return userDao.selectByPhone(phone);
    }

    @Override
    public Map<String, Object> register(User user) {
        User u = userDao.selectByPhone(user.getPhone());
        if (u!=null){
            System.out.println("用户名已经存在");
        }else{
            if(user.getPhone()!=""&&user.getPassword()!=""){
                userDao.insert(user);
            }
        }
        return null;
    }

    @Override
    public String adduser(User user) {
        User user1=userDao.selectByPhone(user.getPhone());
        userDao.insertSelective(user);

        return null;
    }
}
