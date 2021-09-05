package com.zce.market.service.impl;

import com.zce.market.dao.AddressDao;
import com.zce.market.pojo.entity.Address;
import com.zce.market.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 时光荒凉了来时路
 * @Date 2021/9/3 16:23
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressDao addressDao;

    @Override
    public Address getDefaultAddress(Integer userId) {
        Address address = addressDao.selectByUserId(userId, "YES");
        if (address == null) {
            address = addressDao.selectByUserId(userId, "NO");
        }
        return address;
    }

    @Override
    public List<Address> getUserAddressList(Integer userId) {
        return addressDao.getUserAddressList(userId);
    }

}
