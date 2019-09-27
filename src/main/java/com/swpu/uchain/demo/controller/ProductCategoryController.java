package com.swpu.uchain.demo.controller;


import com.swpu.uchain.demo.entity.ProductCategory;
import com.swpu.uchain.demo.form.ProductCategoryForm;
import com.swpu.uchain.demo.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productcategory")
@ControllerAdvice
@Api(tags = "商品种类管理")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/addproductcategory")
    @ApiOperation("增加商品种类")
    public Object addproductcategory(ProductCategoryForm productCategoryForm){
        return productCategoryService.insertProductCategory(productCategoryForm);
    }

/**
 * 在某个商店中删除商品种类
 */
    @GetMapping("/deleteproductcategory")
    @ApiOperation("删除商品种类")
    public Object deleteproductcategory(Integer productcategoryId){
        return productCategoryService.deleteProductCategory(productcategoryId);
    }

    @PostMapping("/updateproduct")
    @ApiOperation("修改商品类型")
    public Object updateproduct(ProductCategory productCategory){
        return productCategoryService.updateProductCategory(productCategory);
    }
    /**
     * 根据商铺的编号查询商品编号
     */
    @GetMapping("/findbyshopid")
    @ApiOperation("根据商铺编号查询商品类型")
    public Object findbyshopid(Integer shopId){
        return productCategoryService.selectAllProductCategoryByShopId(shopId);
    }

    @GetMapping("/findbyproductid")
    @ApiOperation("在商铺中根据商品编号查询")
    public Object findbyproductid(Integer productCategoryId){
        return productCategoryService.selectProductCategoryByProductCategoryId(productCategoryId);
    }
}
