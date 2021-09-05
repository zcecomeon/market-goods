package com.zce.market.service.impl;

import com.zce.market.dao.GoodsDao;
import com.zce.market.dao.ShopCarDao;
import com.zce.market.pojo.dto.ResponseDTO;
import com.zce.market.pojo.entity.Goods;
import com.zce.market.pojo.entity.ShopCar;
import com.zce.market.pojo.vo.ShopCarVO;
import com.zce.market.service.ShopCarService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 17:02
 */
@Service
public class ShopCarServiceImpl implements ShopCarService {
    @Resource
    ShopCarDao shopCarDao;


    @Resource
    GoodsDao goodsDao;

    @Override
    public ResponseDTO edit(ShopCar shopCar) {
        ShopCar dbCar = shopCarDao.findCarByUserIdAndGoods(shopCar);
        if (dbCar == null) {// 数据库根本不存在这个购物车，那么应该给这个用户新增一个购物车
            shopCarDao.insert(shopCar);
        } else {// 就是修改购物车的数量
            dbCar.setCount(shopCar.getCount());
            shopCarDao.updateByPrimaryKeySelective(dbCar);
        }
        // 立刻获取Sess更新购物车数量
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Integer carCount = shopCarDao.selectCarCountByUserId((Integer) session.getAttribute("userId"));
        session.setAttribute("carCount", carCount);
        return ResponseDTO.ok("添加成功", carCount);
    }

    @Override
    public Integer getCarCountByUserId(Integer userId) {
        return shopCarDao.selectCarCountByUserId(userId);
    }

    @Override
    public List<ShopCarVO> findUserCars(Integer userId) {

        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        List<ShopCarVO> carVOS = shopCarDao.findUserCars(userId);

//        for (ShopCarVO s : carVOS) {// 低端做法
//
//            Goods goods = goodsDao.selectByPrimaryKey(s.getGoodsId());
//            s.setGoods(goods);
//
//        }
        List<Goods> goodsList = goodsDao.selectGoodsByIds(carVOS);
        Map<Integer, List<Goods>> collect = goodsList.stream().collect(Collectors.groupingBy(Goods::getGoodsId));
        for (ShopCarVO s : carVOS) {// 低端做法
            List<Goods> goodsList1 = collect.get(s.getGoodsId());
            if (!CollectionUtils.isEmpty(goodsList1)) {
                s.setGoods(goodsList1.get(0));// 取出商品并且设置给这个购物车的商品属性
            }
        }
        return carVOS;
    }
}
