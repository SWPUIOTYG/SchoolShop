package com.swpu.uchain.demo.dao;

import com.swpu.uchain.demo.dto.ShopDTO;
import com.swpu.uchain.demo.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryMapper {

    int deleteByPrimaryKey(Integer productCategoryId);

    int insert(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer productCategoryId);

    List<ProductCategory> selectAllByShopId(Integer shopId);

    ProductCategory selectByProductId(Integer productId);

    int updateByPrimaryKey(ProductCategory record);

    /**
     * 判断该商店是否存在
     * @param shopId
     * @return
     */
    ShopDTO GetShop(Integer shopId);

}