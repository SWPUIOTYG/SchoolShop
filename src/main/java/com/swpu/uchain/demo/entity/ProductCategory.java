package com.swpu.uchain.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductCategory {

    private Long productCategoryId;

    private Long shopId;

    private String productCategoryName;

    private Date createTime;

}
