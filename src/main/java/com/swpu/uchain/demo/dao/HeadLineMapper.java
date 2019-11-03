package com.swpu.uchain.demo.dao;

import com.swpu.uchain.demo.entity.HeadLine;
import java.util.List;

public interface HeadLineMapper {

    int deleteByPrimaryKey(Integer lineId);

    int insert(HeadLine record);

    HeadLine selectByPrimaryKey(Integer lineId);

    List<HeadLine> selectAll();

    int updateByPrimaryKey(HeadLine record);
}