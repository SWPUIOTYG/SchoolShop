package com.swpu.uchain.demo.dao;

import com.swpu.uchain.demo.entity.Shop;
import java.util.List;

public interface ShopMapper {

    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    Shop selectByPrimaryKey(Integer shopId);

    List<Shop> selectAll();

    int updateByPrimaryKey(Shop record);

    List<Shop> selectByOwnerId(Integer ownerId);
}