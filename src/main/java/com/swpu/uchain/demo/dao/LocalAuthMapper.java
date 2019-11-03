package com.swpu.uchain.demo.dao;

import com.swpu.uchain.demo.entity.LocalAuth;
import java.util.List;

public interface LocalAuthMapper {
    int deleteByPrimaryKey(Integer localAuthId);

    int insert(LocalAuth record);

    LocalAuth selectByPrimaryKey(Integer localAuthId);

    List<LocalAuth> selectAll();

    int updateByPrimaryKey(LocalAuth record);
}