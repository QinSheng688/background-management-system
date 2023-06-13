package com.hzlx.service.impl;

import com.hzlx.component.BgmsConfig;
import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.dao.impl.BusinessInfoDaoImpl;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.entity.UserInfo;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.utils.BaseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BusinessInfoServiceImpl implements BusinessInfoService {
    BusinessInfoDao businessInfoDao=new BusinessInfoDaoImpl();
    @Override
    public void manage(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        request.setAttribute(BgmsConfig.BUS_LIST, businessInfoDao.getBusAll(keyword));
        request.setAttribute(BgmsConfig.KEYWORD,keyword);
    }

    @Override
    public String getBus(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (id == null) {
            return BaseResult.error(20001,"商家id不能为空");
        }
        BusinessInfo businessInfo = businessInfoDao.getBusById(id);
        return BaseResult.success(businessInfo);
    }

    @Override
    public String addOrEditBus(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String busName = request.getParameter("busName");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        if (id==null||id==""){
            int rows=businessInfoDao.addBus(name, busName, tel, address);
            if (rows>0){
                return BaseResult.success();
            }else {
                return BaseResult.error(20002,"新增商家失败");
            }
        }else {
            int rows=businessInfoDao.editBus(id,name, busName, tel, address);
            if (rows>0){
                return BaseResult.success();
            }else {
                return BaseResult.error(20003,"修改商家失败");
            }
        }
    }

    @Override
    public String deleteBuses(HttpServletRequest request) {
        String idsStr = request.getParameter("ids");
        String[] ids = idsStr.substring(0, idsStr.length() - 1).split(",");

        int rows=businessInfoDao.deleteBusById(ids);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(20003,"删除商家失败");
        }
    }

    @Override
    public String enableBuses(HttpServletRequest request) {
        Integer sta = Integer.parseInt(request.getParameter("sta"));
        String idsStr = request.getParameter("ids");
        String[] ids = idsStr.substring(0, idsStr.length() - 1).split(",");
        int rows= businessInfoDao.batchUpdateBusStatus(ids,sta);
        if (rows>0){
            return BaseResult.success();
        }else {
            return BaseResult.error(20003,"更改商家失败");
        }
    }
}
