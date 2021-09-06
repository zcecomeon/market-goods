package com.zce.market.controller;


import com.zce.market.dao.UserDao;
import com.zce.market.pojo.entity.User;
import com.zce.market.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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

    @RequestMapping("/")
    String index(Model model){
        //下面return会自动查找页面
        User user = userDao.selectByPrimaryKey(1);
        model.addAttribute("type",typeService.selectTypesByParentId(-1));
        return "index";//此时不需要@ResponseBody
    }
}
