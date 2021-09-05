package com.zce.market.pojo.entity;

import java.io.Serializable;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 11:23
 */
public class ShopCar implements Serializable {
    /**
     * 购物车id
     */
    private Integer shopCardId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 数量
     */
    private Integer count;

    private static final long serialVersionUID = 1L;

    public Integer getShopCardId() {
        return shopCardId;
    }

    public void setShopCardId(Integer shopCardId) {
        this.shopCardId = shopCardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}