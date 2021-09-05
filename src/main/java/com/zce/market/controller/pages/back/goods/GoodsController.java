package com.zce.market.controller.pages.back.goods;
import com.zce.market.controller.BaseController;
import com.zce.market.pojo.entity.Goods;
import com.zce.market.service.GoodsService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/pages/back/goods")
public class GoodsController extends BaseController {

    Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    GoodsService goodsService;

    @RequestMapping("addPre")
    String addPre(){
        return "pages/back/goods/goods-addPre";
    }

    @RequestMapping("add")
    @ResponseBody
    Map<String,Object> add(Goods goods, MultipartFile pic){
        System.err.println(goods);
        //视频代码
        if("on".equals(goods.getOnSale())){
            goods.setOnSale("Yes");
        }else {
            goods.setOnSale("NO");
        }
        String imgUrl = uploadFile("/upload/goods/", pic);//图片存放数据库路径
        goods.setImg(imgUrl);
        return goodsService.add(goods);
    }

}
