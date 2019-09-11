package com.swpu.uchain.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductImg {

    private Long productImgId;

    private String imgAddr;

    private  String imgDesc;

    private Date createTime;

    private Long productId;
}
