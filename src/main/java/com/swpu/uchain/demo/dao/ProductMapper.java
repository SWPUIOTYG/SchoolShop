package com.swpu.uchain.demo.dao;

import com.swpu.uchain.demo.entity.Product;
import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    Product selectByPrimaryKey(Integer productId);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);

    List<Product> selectByShopId(Integer shopId);

    Product selectByProductName(String productName);
}