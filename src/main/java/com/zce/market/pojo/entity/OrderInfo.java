package com.zce.market.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 11:23
 */
public class OrderInfo implements Serializable {
    /**
     * 订单详情表
     */
    private Integer orderInfoId;

    /**
     * 外键哪个订单的
     */
    private String orderId;

    /**
     * 原来的商品的连接
     */
    private Integer originGoodsId;

    /**
     * 下单的时候的商品价格
     */
    private BigDecimal price;

    /**
     * 这个商品下单的数量
     */
    private Integer count;

    /**
     * 商品下单时候的价格
     */
    private String img;

    /**
     * 下单的时候的原价
     */
    private Double oldPrice;

    private static final long serialVersionUID = 1L;

    public Integer getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Integer orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOriginGoodsId() {
        return originGoodsId;
    }

    public void setOriginGoodsId(Integer originGoodsId) {
        this.originGoodsId = originGoodsId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }
}