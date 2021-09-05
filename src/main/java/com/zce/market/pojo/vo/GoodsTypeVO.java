package com.zce.market.pojo.vo;

import com.zce.market.pojo.entity.GoodsType;
import lombok.Data;

import java.util.List;

/**
 * creator：Administrator
 * date:2019/12/18
 */
@Data
public class GoodsTypeVO extends GoodsType {
    /**
     * 装子商品类型的集合
     */
    private List<GoodsTypeVO> childrenTypes;

}
