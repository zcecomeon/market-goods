package com.zce.market.controller.pages.back.shopcar;

import com.zce.market.pojo.dto.ResponseDTO;
import com.zce.market.pojo.entity.ShopCar;
import com.zce.market.pojo.vo.ShopCarVO;
import com.zce.market.service.ShopCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/5 19:57
 */

@Controller
@RequestMapping("/pages/back/shopCar")
public class ShopCarController {
    Logger logger = LoggerFactory.getLogger(ShopCarController.class);
    @Resource
    ShopCarService shopCarService;
    /**
     * 真正添加商品的方法
     *
     * @returnC
     */

    @RequestMapping("showMyCar")
    String shwoMyCar() {
        return "pages/back/shopcar/car-list";
    }

    @RequestMapping("edit")
    @ResponseBody
    ResponseDTO edit(ShopCar shopCar, HttpSession session) {
        if (StringUtils.isEmpty(session.getAttribute("userId"))) {
            // 未授权
            return ResponseDTO.fail("操作失败，请登录", null, 401, 401);
        }
        shopCar.setUserId((Integer) session.getAttribute("userId"));
        return shopCarService.edit(shopCar);
    }
    /**
     * 真正添加商品的方法
     *
     * @return
     */


}
