package com.swpu.uchain.demo.service.Impl;

import com.swpu.uchain.demo.dao.ShopCategoryMapper;
import com.swpu.uchain.demo.entity.ShopCategory;
import com.swpu.uchain.demo.enums.ResultEnum;
import com.swpu.uchain.demo.form.ShopCategoryForm;
import com.swpu.uchain.demo.service.ShopCategoryService;
import com.swpu.uchain.demo.util.ResultVOUtil;
import com.swpu.uchain.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Override
    public boolean insert(ShopCategory shopCategory) {
        return shopCategoryMapper.insert(shopCategory)==1;
    }

    @Override
    public boolean delete(Integer shopcategoryId) {
        return shopCategoryMapper.deleteByPrimaryKey(shopcategoryId)==1;
    }

    @Override
    public boolean update(ShopCategory shopCategory) {
        return shopCategoryMapper.updateByPrimaryKey(shopCategory)==1;
    }

    @Override
    public ResultVO insertCategory(ShopCategoryForm shopCategoryForm) {
        if(shopCategoryMapper.selectByPrimaryKey(shopCategoryForm.getShopCategoryId())!=null){
            return ResultVOUtil.error(ResultEnum.SHOP_CATEGORY_ALREADY_EXIST);
        }
        ShopCategory shopCategory=new ShopCategory();
        BeanUtils.copyProperties(shopCategoryForm,shopCategory);
        shopCategory.setCreateTime(new Date());
        shopCategory.setLastEditTime(new Date());
        if(insert(shopCategory)){
            return ResultVOUtil.success(shopCategory);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO deleteCategory(Integer categoryId) {
        if(shopCategoryMapper.selectByPrimaryKey(categoryId)==null){
            return ResultVOUtil.error(ResultEnum.SHOP_CATEGORY_NOT_EXIST);
        }
        if(delete(categoryId)){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO updateCategory(ShopCategory shopCategory) {
        if(shopCategoryMapper.selectByPrimaryKey(shopCategory.getShopCategoryId())==null){
            return ResultVOUtil.error(ResultEnum.SHOP_CATEGORY_NOT_EXIST);
        }
        shopCategory.setLastEditTime(new Date());
        if(update(shopCategory)){
            return ResultVOUtil.success(shopCategory);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO selectByCategoryId(Integer categoryId) {
        if(shopCategoryMapper.selectByPrimaryKey(categoryId)==null){
            return ResultVOUtil.error(ResultEnum.SHOP_CATEGORY_NOT_EXIST);
        }
        ShopCategory shopCategory=shopCategoryMapper.selectByPrimaryKey(categoryId);
        if(shopCategory!=null){
            return ResultVOUtil.success(shopCategory);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO selectAllCategory() {
        List<ShopCategory> shopCategoryList=shopCategoryMapper.selectAll();
        return ResultVOUtil.success(shopCategoryList);
    }
}
