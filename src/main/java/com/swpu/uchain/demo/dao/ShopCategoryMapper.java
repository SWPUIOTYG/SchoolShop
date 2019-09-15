package com.swpu.uchain.demo.dao;

import com.swpu.uchain.demo.entity.ShopCategory;
import java.util.List;

public interface ShopCategoryMapper {

    int deleteByPrimaryKey(Integer shopCategoryId);

    int insert(ShopCategory record);

    ShopCategory selectByPrimaryKey(Integer shopCategoryId);

    List<ShopCategory> selectAll();

    int updateByPrimaryKey(ShopCategory record);
}