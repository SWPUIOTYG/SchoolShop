package com.swpu.uchain.demo.service;

import com.swpu.uchain.demo.entity.Shop;
import com.swpu.uchain.demo.entity.ShopCategory;
import com.swpu.uchain.demo.form.ShopCategoryForm;
import com.swpu.uchain.demo.vo.ResultVO;

public interface ShopCategoryService {

    boolean insert(ShopCategory shopCategory);

    boolean delete(Integer shopcategoryId);

    boolean update(ShopCategory shopCategory);

    ResultVO insertCategory(ShopCategoryForm shopCategoryForm);

    ResultVO deleteCategory(Integer categoryId);

    ResultVO updateCategory(ShopCategory shopCategory);

    ResultVO selectByCategoryId(Integer categoryId);

    ResultVO selectAllCategory();
}
