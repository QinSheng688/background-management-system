package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BusinessInfoService {
    void manage(HttpServletRequest request, HttpServletResponse response);

    String getBus(HttpServletRequest request);

    String addOrEditBus(HttpServletRequest request);

    String deleteBuses(HttpServletRequest request);

    String enableBuses(HttpServletRequest request);
}
