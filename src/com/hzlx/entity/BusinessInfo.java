package com.hzlx.entity;

import java.io.Serializable;
import java.util.Date;

public class BusinessInfo implements Serializable {
    Integer id;
    String name;
    String busName;
    String tel;
    String address;
    Date createTime;
    Integer status;


    public BusinessInfo() {
    }

    public BusinessInfo(Integer id, String name, String busName, String tel, String address, Date createTime, Integer status) {
        this.id = id;
        this.name = name;
        this.busName = busName;
        this.tel = tel;
        this.address = address;
        this.createTime = createTime;
        this.status = status;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return busName
     */
    public String getBusName() {
        return busName;
    }

    /**
     * 设置
     * @param busName
     */
    public void setBusName(String busName) {
        this.busName = busName;
    }

    /**
     * 获取
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "BusinessInfo{id = " + id + ", name = " + name + ", busName = " + busName + ", tel = " + tel + ", address = " + address + ", createTime = " + createTime + ", status = " + status + "}";
    }
}
