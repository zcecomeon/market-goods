package com.zce.market.service;

import com.zce.market.pojo.dto.ResponseDTO;
import com.zce.market.pojo.entity.GoodsType;
import com.zce.market.pojo.vo.GoodsTypeVO;

import java.util.List;

/**
 * creator：Administrator
 * date:2019/12/18
 */
public interface TypeService {
    /**
     * 增加商品类型
     *
     * @param goodsType
     * @return
     */
    ResponseDTO add(GoodsType goodsType);

    /**
     * 查询出所有一级商品类型给前端使用
     *
     * @return
     */
    List<GoodsTypeVO> selectTypesByParentId(int i);

}
