package com.zce.market.dao;

import com.zce.market.pojo.entity.GoodsType;
import com.zce.market.pojo.vo.GoodsTypeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsTypeDao {
    int deleteByPrimaryKey(Integer goodsTypeId);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer goodsTypeId);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);

    List<GoodsTypeVO> selectTypesByParentId(int i);

    //List<GoodsType> selectTypesByParentId(int i);

    List<GoodsTypeVO> selectTypesByParentIds(@Param("ids") List parentTypes);
}