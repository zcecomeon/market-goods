package com.zce.market.controller.pages.front;

import com.zce.market.pojo.entity.User;
import com.zce.market.service.ShopCarService;
import com.zce.market.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 这个类是干什么的
 * 这个类一个登录的控制器，完成登录检验操作等功能
 * @Author 时光荒凉了来时路
 * @Date 2021/9/2 15:27
 */

@Controller
@RequestMapping("/pages/front")
public class LoginController {
    @Resource
    UserService userService;
    @Resource
    ShopCarService shopCarService;
    @RequestMapping("loginPage")
    String loginPage() {
        return "pages/front/login/loginPage";
    }

    /**
     * 验证用户名密码执行登录操作的方法
     *
     * @return
     */
    @RequestMapping("login")
    String login(User user, Model model, HttpSession session) {

        if ("".equals(user.getPhone()) || user.getPhone() == null) {// 你电话都不传，就不必查了，直接登录失败
            model.addAttribute("errorMsg", "请输入手机号登录！");
            return "pages/front/login/loginPage"; // 继续返回登录页面继续登录。
        }
        boolean loginResult = userService.login(user);

        if (loginResult) {// 登录成功，返回到后台首页
            User dbUser = userService.getUserByPhone(user.getPhone());
//            model.addAttribute("UserName",dbUser.getRealName());
            session.setAttribute("userName",dbUser.getRealName());
            session.setAttribute("userId", dbUser.getUserId());
            session.setAttribute("carCount", shopCarService.getCarCountByUserId(dbUser.getUserId()));
            return "pages/back/backHome";
        }
        model.addAttribute("errorMsg", "登陆失败，手机号或密码错误！");
        return "pages/front/login/loginPage";
    }
    @RequestMapping("toPage")
    String toPage(HttpServletRequest request){
        String url = request.getParameter("url");
        return url;
    }

}
