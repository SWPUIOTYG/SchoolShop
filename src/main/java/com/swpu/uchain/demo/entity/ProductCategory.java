package com.swpu.uchain.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductCategory {

    private Integer productCategoryId;

    private Integer shopId;

    private String productCategoryName;

    private Date createTime;

}
