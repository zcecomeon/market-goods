package com.zce.market.pojo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 11:23
 */
public class GoodsType implements Serializable {

    /**
     * 商品类型id
     */
    private Integer goodsTypeId;

    /**
     * 父类型id
     */
    private Integer parentTypeId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型序号，根据序号排序优先展示
     */
    private Integer sort;

    /**
     * 图标样式
     */
    private String iconClass;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Integer getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(Integer parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }
}