package com.zce.market.controller.pages.back.type;
import com.zce.market.controller.BaseController;
import com.zce.market.pojo.dto.ResponseDTO;
import com.zce.market.pojo.entity.Goods;
import com.zce.market.pojo.entity.GoodsType;
import com.zce.market.service.GoodsService;
import com.zce.market.service.TypeService;
import org.apache.coyote.Response;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.util.Map;
/*
*@author: 时光荒凉了来时路
*@date: 
*@param: 
*@return: 
*@description: Read the notes carefully
**/
@Controller
@RequestMapping("/pages/back/type")
public class TypeController extends BaseController {
    Logger logger = LoggerFactory.getLogger(TypeController.class);
    @Resource
    TypeService typeService;
    @RequestMapping("addPre")
    String addPre(Model model){
        return "pages/back/type/type-addPre";
    }

    @RequestMapping("add")
    @ResponseBody


    ResponseDTO add(GoodsType goodsType){
        return typeService.add(goodsType);
    }

}
