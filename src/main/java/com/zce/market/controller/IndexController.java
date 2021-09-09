package com.zce.market.controller;


import com.zce.market.dao.UserDao;
import com.zce.market.pojo.entity.User;
import com.zce.market.service.TypeService;
import com.zce.market.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 22:49
 */
@Controller
public class IndexController {
    //@ResponseBody //表示返回字符串给前端
    @Resource
    UserDao userDao;

    @Resource
    TypeService typeService;

    @Resource
    UserService userService;

    @RequestMapping("/")
    String index(Model model){
        //下面return会自动查找页面
        User user = userDao.selectByPrimaryKey(1);
        model.addAttribute("types",typeService.selectTypesByParentId(-1));
        return "index";//此时不需要@ResponseBody
    }
    @RequestMapping("/pages/back/dashBoard")
    String dashBoard() {
        return "pages/back/dashBoard";
    }

//    @RequestMapping("login")
//    String login(User user, Model model, HttpSession session) {
//
//        if ("".equals(user.getPhone()) || user.getPhone() == null) {// 你电话都不传，就不必查了，直接登录失败
//            model.addAttribute("errorMsg", "请输入手机号登录！");
//            return "pages/front/login/loginPage"; // 继续返回登录页面继续登录。
//        }
//        boolean loginResult = userService.login(user);
//
//        if (loginResult) {// 登录成功，返回到后台首页
//            User dbUser = userService.getUserByPhone(user.getPhone());
//            session.setAttribute("userId", dbUser.getUserId());
//            session.setAttribute("carCount", shopCarService.getCarCountByUserId(dbUser.getUserId()));
//            return "pages/back/backHome";
//        }
//        model.addAttribute("errorMsg", "登陆失败，手机号或密码错误！");
//        return "pages/front/login/loginPage";
//    }
}
