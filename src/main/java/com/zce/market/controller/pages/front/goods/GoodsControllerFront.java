package com.zce.market.controller.pages.front.goods;

import com.zce.market.controller.BaseController;
import com.zce.market.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/pages/front/goods")
public class GoodsControllerFront extends BaseController {

    Logger logger = LoggerFactory.getLogger(GoodsControllerFront.class);

    @Resource
    GoodsService goodsService;

    @RequestMapping("goodsDetail/{goodsId}")
    String goodsDetail(@PathVariable Integer goodsId, Model model) {
        model.addAttribute("goods", goodsService.getGoodsDetail(goodsId));
        return "pages/front/goods/goods-detail";
    }

}
