package com.zce.market.service.impl;

import com.zce.market.dao.GoodsDao;
import com.zce.market.pojo.dto.ResponseDTO;
import com.zce.market.pojo.entity.Goods;
import com.zce.market.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 16:23
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsDao goodsDao;

    @Override
    public Map<String, Object> add(Goods goods) {
        Map<String, Object> resMap = new HashMap<>();
        int i = goodsDao.insertSelective(goods);
        if (i == 1) {//就表示增加商品成功
            resMap.put("res", true);// 增加成功；
            resMap.put("msg", "添加商品成功");// 添加商品成功
        } else {
            resMap.put("res", false);// 增加成功；
            resMap.put("msg", "添加商品失败");// 增加成功；
        }
        return resMap;
    }

    @Override
    public ResponseDTO getGoodsByTypeId(Integer typeId) {
        List<Goods> goods = null;
        try {
            goods = goodsDao.getGoodsByTypeId(typeId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.fail("查询商品失败");
        }
        return ResponseDTO.ok("查询商品成功", goods);
    }

    @Override
    public Goods getGoodsDetail(Integer goodsId) {
        return goodsDao.selectByPrimaryKey(goodsId);
    }
}
