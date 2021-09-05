package com.zce.market.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 11:23
 */
public class Goods implements Serializable {
    /**
     * 商品主键id
     */
    private Integer goodsId;

    /**
     * 商品类型id
     */
    private Integer goodsTypeId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 图片路径字符串
     */
    private String img;

    /**
     * 商品原价
     */
    private Double oldPrice;

    /**
     * 现在价格
     */
    private BigDecimal price;

    /**
     * 是否在售：yes或no
     */
    private String onSale;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 库存
     */
    private Integer count;

    /**
     * 商家名字
     */
    private String merchantName;

    /**
     * 评价次数
     */
    private Integer evaluationCount;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOnSale() {
        return onSale;
    }

    public void setOnSale(String onSale) {
        this.onSale = onSale;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Integer getEvaluationCount() {
        return evaluationCount;
    }

    public void setEvaluationCount(Integer evaluationCount) {
        this.evaluationCount = evaluationCount;
    }
}