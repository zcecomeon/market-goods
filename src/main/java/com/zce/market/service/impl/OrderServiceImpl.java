package com.zce.market.service.impl;

import com.zce.market.dao.OrderInfoDao;
import com.zce.market.dao.UserOrderDao;
import com.zce.market.pojo.dto.ResponseDTO;
import com.zce.market.pojo.entity.OrderInfo;
import com.zce.market.pojo.entity.UserOrder;
import com.zce.market.pojo.vo.ShopCarVO;
import com.zce.market.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 16:23
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    UserOrderDao userOrderDao;

    @Resource
    OrderInfoDao orderInfoDao;


    @Override
    public ResponseDTO addOrder(UserOrder userOrder, List<ShopCarVO> carVOS) {
        // 编写业务逻辑
        int i = userOrderDao.insertSelective(userOrder);
        int x = 0;
        if (i == 1) {
            // 就应该继续插入订单详情
            for (ShopCarVO s : carVOS) {
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setOrderId(userOrder.getOrderId());
                orderInfo.setCount(s.getCount());
                orderInfo.setImg(s.getGoods().getImg());
                orderInfo.setOldPrice(s.getGoods().getOldPrice());
                orderInfo.setPrice(s.getGoods().getPrice());

                orderInfo.setOriginGoodsId(s.getGoodsId());
                x += orderInfoDao.insert(orderInfo);
            }
            if (x == carVOS.size()) {
                return ResponseDTO.ok("下单成功！");
            } else {
                return ResponseDTO.ok("下单失败！");
            }
        }
        return ResponseDTO.ok("下单失败！");
    }

    @Override
    public UserOrder getOrderDetailByOrderId(String orderId) {
        return userOrderDao.selectByPrimaryKey(orderId);
    }

    @Override
    public boolean updatePayStatus(UserOrder dbOrder) {
        return userOrderDao.updateByPrimaryKeySelective(dbOrder) == 1;
    }
}
