package com.hzlx.dao;

import com.hzlx.entity.BusinessInfo;

import java.util.List;

public interface BusinessInfoDao {
    List<BusinessInfo> getBusAll(String keyword);

    BusinessInfo getBusById(String id);

    int addBus(String name,String busName,String tel,String address);

    int editBus(String id, String name, String busName, String tel, String address);

    int deleteBusById(String[] ids);

    int batchUpdateBusStatus(String[] ids, Integer sta);
}
