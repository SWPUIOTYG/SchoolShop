package com.swpu.uchain.demo.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Product {
    private Long productId;
    private String productName;
    private String productDesc;
    private String imgAddr;
    private String normalPrice;
    private String promotionPrice;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    /**
     * 0.下架  1.在前端系统展示
     */
    private Integer enableStatus;
    private List<ProductImg> productImgList;
    private ProductCategory productCategory;
    private Shop shop;

}
