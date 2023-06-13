package com.hzlx.controller;


import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/bus")
public class BusinessInfoController {
    BusinessInfoService businessInfoService=new BusinessInfoServiceImpl();


    @RequestMapping("/manage")

    public String manage(HttpServletRequest request, HttpServletResponse response){
        businessInfoService.manage(request, response);
        return "pages/bus";
    }

    @RequestMapping("/getBus")
    @ResponseBody
    public String getUser(HttpServletRequest request,HttpServletResponse response){
        return businessInfoService.getBus(request);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(HttpServletRequest request ,HttpServletResponse response){
        return  businessInfoService.addOrEditBus(request);
    }

    @RequestMapping("/addBus")
    @ResponseBody
    public String addBus(HttpServletRequest request ,HttpServletResponse response){
        return  businessInfoService.addOrEditBus(request);
    }

    @RequestMapping("/deleteBuses")
    @ResponseBody
    public String deleteBuses(HttpServletRequest request ,HttpServletResponse response){
        return  businessInfoService.deleteBuses(request);
    }

    @RequestMapping("/enableBuses")
    @ResponseBody
    public String enableBuses(HttpServletRequest request ,HttpServletResponse response){
        return  businessInfoService.enableBuses(request);
    }
}
