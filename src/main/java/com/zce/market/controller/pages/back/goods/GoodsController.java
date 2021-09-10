package com.zce.market.controller.pages.back.goods;
import com.zce.market.controller.BaseController;
import com.zce.market.pojo.dto.ResponseDTO;
import com.zce.market.pojo.entity.Goods;
import com.zce.market.service.GoodsService;
import com.zce.market.service.TypeService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.Map;

@Controller
@RequestMapping("/pages/back/goods")
public class GoodsController extends BaseController {

    Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    GoodsService goodsService;

    @Resource
    TypeService typeService;
    @RequestMapping("addPre")
    String addPre(Model model){
        model.addAttribute("types",typeService.selectTypesByParentId(-1));
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
    @RequestMapping("test")
    @ResponseBody
    String test(){
        return "pages/front/login/testpage.html";
    }
    /**
     * 真正添加商品的方法
     *
     * @return
     */
    @RequestMapping("getGoodsByTypeId/{typeId}")
    @ResponseBody
    ResponseDTO getGoodsByTypeId(@PathVariable Integer typeId) {
        return goodsService.getGoodsByTypeId(typeId);
    }
}
