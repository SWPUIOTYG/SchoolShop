package com.swpu.uchain.demo.service.Impl;

import com.swpu.uchain.demo.dao.ProductCategoryMapper;
import com.swpu.uchain.demo.entity.ProductCategory;
import com.swpu.uchain.demo.enums.ResultEnum;
import com.swpu.uchain.demo.form.ProductCategoryForm;
import com.swpu.uchain.demo.service.ProductCategoryService;
import com.swpu.uchain.demo.util.ResultVOUtil;
import com.swpu.uchain.demo.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public boolean insert(ProductCategory productCategory) {
        return productCategoryMapper.insert(productCategory)==1;
    }

    @Override
    public boolean update(ProductCategory productCategory) {
        return productCategoryMapper.updateByPrimaryKey(productCategory)==1;
    }

    @Override
    public boolean delete(Integer productCategoryId) {
        return productCategoryMapper.deleteByPrimaryKey(productCategoryId)==1;
    }

    @Override
    public ResultVO insertProductCategory(ProductCategoryForm productCategoryForm) {
        /**
         * 种类编号不能相同 一个编号对应一个分类
         */
        if(productCategoryMapper.selectByPrimaryKey(productCategoryForm.getProductCategoryId())!=null){
            return ResultVOUtil.error(ResultEnum.PRODUCT_CATEGORY_ALREADY_EXIST);
        }
        ProductCategory productCategory=new ProductCategory();
        BeanUtils.copyProperties(productCategoryForm,productCategory);
        productCategory.setCreateTime(new Date());
        if(insert(productCategory)){
            return ResultVOUtil.success(productCategory);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO deleteProductCategory(Integer productCategoryId) {
        if(productCategoryMapper.selectByPrimaryKey(productCategoryId)==null){
            return ResultVOUtil.error(ResultEnum.PRODUCT_CATEGORY_NOT_EXIST);
        }
        if(delete(productCategoryId)){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO updateProductCategory(ProductCategory productCategory) {
        if(productCategoryMapper.selectByPrimaryKey(productCategory.getProductCategoryId())==null){
            return ResultVOUtil.error(ResultEnum.PRODUCT_CATEGORY_NOT_EXIST);
        }
        if(update(productCategory)){
            productCategory.setCreateTime(new Date());
            return ResultVOUtil.success(productCategory);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO selectAllProductCategoryByShopId(Integer shopId) {
       if(productCategoryMapper.GetShop(shopId)==null){
            return ResultVOUtil.error(ResultEnum.SHOP_NOT_EXIST);
       }
        List<ProductCategory> productCategoryList=productCategoryMapper.selectAllByShopId(shopId);
       return ResultVOUtil.success(productCategoryList);
    }


    @Override
    public ResultVO selectProductCategoryByProductCategoryId(Integer productCategoryId) {
        if(productCategoryMapper.selectByPrimaryKey(productCategoryId)==null){
            return ResultVOUtil.error(ResultEnum.PRODUCT_CATEGORY_NOT_EXIST);
        }
        return ResultVOUtil.success(productCategoryMapper.selectByPrimaryKey(productCategoryId));
    }
}
