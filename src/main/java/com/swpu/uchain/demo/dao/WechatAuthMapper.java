package com.swpu.uchain.demo.dao;

import com.swpu.uchain.demo.entity.WechatAuth;
import java.util.List;

public interface WechatAuthMapper {
    int deleteByPrimaryKey(Integer productImgId);

    int insert(WechatAuth record);

    WechatAuth selectByPrimaryKey(Integer productImgId);

    List<WechatAuth> selectAll();

    int updateByPrimaryKey(WechatAuth record);
}