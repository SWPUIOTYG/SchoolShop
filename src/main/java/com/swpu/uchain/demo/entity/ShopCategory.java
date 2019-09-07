package com.swpu.uchain.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author EmiYkr
 */
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    /**
     * 描述
     */
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
