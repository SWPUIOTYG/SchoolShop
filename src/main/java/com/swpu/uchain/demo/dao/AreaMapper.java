package com.swpu.uchain.demo.dao;

import com.swpu.uchain.demo.entity.Area;
import java.util.List;

public interface AreaMapper {

    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    Area selectByPrimaryKey(Integer areaId);

    List<Area> selectAll();

    int updateByPrimaryKey(Area record);

    Area selectByAreaName(String areaName);
}