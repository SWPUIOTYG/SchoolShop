package com.swpu.uchain.demo.dao;

import com.swpu.uchain.demo.entity.PersonInfo;
import java.util.List;

public interface PersonInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(PersonInfo record);

    PersonInfo selectByPrimaryKey(Integer userId);

    List<PersonInfo> selectAll();

    int updateByPrimaryKey(PersonInfo record);
}