package com.swpu.uchain.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class WechatAuth {
    private Long wechatAuthId;
    private String openId;
    private Date createTime;
    private PersonInfo personInfo;

}
