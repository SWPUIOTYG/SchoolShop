package com.swpu.uchain.demo.service;

import com.swpu.uchain.demo.entity.ProductCategory;
import com.swpu.uchain.demo.form.ProductCategoryForm;
import com.swpu.uchain.demo.vo.ResultVO;

public interface ProductCategoryService {
    boolean insert(ProductCategory productCategory);

    boolean update(ProductCategory productCategory);

    boolean delete(Integer productCategoryId);

    ResultVO insertProductCategory(ProductCategoryForm productCategoryForm);

    ResultVO deleteProductCategory(Integer productCategoryId);

    ResultVO updateProductCategory(ProductCategory productCategory);

    ResultVO selectAllProductCategoryByShopId(Integer shopId);

    ResultVO selectProductCategoryByProductCategoryId(Integer productCategoryId);

}
