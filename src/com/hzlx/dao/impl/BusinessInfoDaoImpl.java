package com.hzlx.dao.impl;

import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.entity.UserInfo;
import com.hzlx.utils.BaseDao;
import com.mysql.cj.util.StringUtils;

import java.util.List;

public class BusinessInfoDaoImpl extends BaseDao<BusinessInfo> implements BusinessInfoDao {
    @Override
    public List<BusinessInfo> getBusAll(String keyword) {
        String sql="select * from t_business_info";
        if (!StringUtils.isNullOrEmpty(keyword)){
            sql+=" where name like concat('%',?,'%')";
            return selectListForObject(sql, BusinessInfo.class,keyword);
        }
        return  selectListForObject(sql,BusinessInfo.class);
    }

    @Override
    public BusinessInfo getBusById(String id) {
        String sql="select * from t_business_info where id=?";
        return  selectOne(sql,BusinessInfo.class,id);
    }

    @Override
    public int addBus(String name,String busName,String tel,String address) {
        String sql="insert into t_business_info values(default,?,?,?,?,now(),default)";
        return  executeUpdate(sql,name,busName,tel,address);
    }

    @Override
    public int editBus(String id, String name, String busName, String tel, String address) {
        String sql="update t_business_info set name=?,bus_name=?,tel=?,address=? where id=?";
        return executeUpdate(sql,name,busName,tel,address,id);
    }

    @Override
    public int deleteBusById(String[] ids) {
        String sql="delete from t_business_info  where id in (";
        for (int i = 0; i < ids.length; i++) {
            if (i==ids.length-1){
                sql+="?";
            }else {
                sql+="?,";
            }
        }
        sql+= ")";
        return executeUpdate(sql,ids);
    }

    @Override
    public int batchUpdateBusStatus(String[] ids, Integer sta) {
        String sql="update t_business_info set `status`=? where id in (";
        for (int i = 0; i < ids.length; i++) {
            if (i==ids.length-1){
                sql+="?";
            }else {
                sql+="?,";
            }
        }
        sql+= ")";
        return executeUpdate(sql,sta,ids);
    }
}
