package com.zce.market.dao;

import com.zce.market.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    //根据主键删除
    int deleteByPrimaryKey(Integer userId);
    //
    int insert(User record);
    //选择性插入
    int insertSelective(User record);
    //根据主键查询
    User selectByPrimaryKey(Integer userId);
    //根据主键更新(传了值的字段就更新，否则不更新
    int updateByPrimaryKeySelective(User record);
    //
    int updateByPrimaryKey(User record);

    //根据真是名称查询用户信息
    User selectUserByRealName(String realName);

    /**根据用户的电话号码
     * @param
     * @return
     */
    User selectByPhone(String phone) ;
}