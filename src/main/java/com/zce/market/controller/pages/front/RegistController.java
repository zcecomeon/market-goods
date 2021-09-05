package com.zce.market.controller.pages.front;
import com.zce.market.dao.UserDao;
import com.zce.market.pojo.entity.User;
import com.zce.market.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/5 9:27
 */
//@RequestMapping("loginPage")
//    String loginPage() {
//            return "pages/front/login/loginPage";
//            }
@Controller
@RequestMapping("/pages/front")
public class RegistController {
    UserService userService;

    @RequestMapping("registPage")
    String registPage(){
        return "pages/front/login/registPage.html";//这里才是返回页面
    }

    @RequestMapping("regist")
    @ResponseBody
    String regist(User user){
        System.err.println(user);//数据能拿到
        return userService.adduser(user);
    }
}
