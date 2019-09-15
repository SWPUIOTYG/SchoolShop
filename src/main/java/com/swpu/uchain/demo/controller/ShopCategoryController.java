package com.swpu.uchain.demo.controller;

import com.swpu.uchain.demo.entity.ShopCategory;
import com.swpu.uchain.demo.form.ShopCategoryForm;
import com.swpu.uchain.demo.service.ShopCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
@Api(tags = "商铺种类管理")
@ControllerAdvice
public class ShopCategoryController {
    @Autowired
    private ShopCategoryService shopCategoryService;

    @ApiOperation("添加商品种类")
    @PostMapping("/category/insert")
    public Object categoryinsert(ShopCategoryForm shopCategoryForm){
        return shopCategoryService.insertCategory(shopCategoryForm);
    }

    @ApiOperation("删除商品种类")
    @GetMapping("/category/delete")
    public Object categorydelete(Integer categoryId){
        return shopCategoryService.deleteCategory(categoryId);
    }

    @ApiOperation("修改商品种类")
    @PostMapping("/category/update")
    public Object categoryupdate(ShopCategory shopCategory){
        return shopCategoryService.updateCategory(shopCategory);
    }

    @ApiOperation("查找商品种类")
    @GetMapping("/category/find")
    public Object categoryselect(Integer categoryId){
        return shopCategoryService.selectByCategoryId(categoryId);
    }

    @ApiOperation("查询店铺所有商品种类")
    @GetMapping("/category/findall")
    public Object categoryfindall(){
        return shopCategoryService.selectAllCategory();
    }
}
