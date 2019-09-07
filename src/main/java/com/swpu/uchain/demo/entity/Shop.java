package com.swpu.uchain.demo.entity;

import lombok.Data;

import java.awt.geom.Area;
import java.util.Date;

@Data
public class Shop {
    private Long shopId;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    /**
     * 店铺的审核信息  -1不可用 0审核中 1可用
     */
    private Integer enableStatus;
    /**
     *  超级管理员给店家的建议
     */
    private String advice;
    private Area area;
    private PersonInfo owner;
    private ShopCategory shopCategory;
}
