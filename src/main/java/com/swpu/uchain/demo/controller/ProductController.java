package com.swpu.uchain.demo.controller;

import com.swpu.uchain.demo.entity.Product;
import com.swpu.uchain.demo.form.ProductForm;
import com.swpu.uchain.demo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
@Api(tags = "商品管理")
@ControllerAdvice
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("添加商品")
    @PostMapping("/insertproduct")
    public Object insertproduct(@Valid ProductForm productForm){
        return productService.insertProduct(productForm);
    }

    @ApiOperation("删除商品")
    @GetMapping("/deleteproduct")
    public Object deleteproduct(Integer productId){
        return productService.deleteProduct(productId);
    }

    @ApiOperation("修改商品信息")
    @PostMapping("/updateproductinfo")
    public Object updateproductinfo(@Valid Product product){
        return productService.updateProduct(product);
    }

    @ApiOperation("查询店铺里所有商品信息")
    @GetMapping("/selectallproduct")
    public Object selectallproduct(){
        return productService.selectAllProduct();
    }

    @ApiOperation("根据商品号查询商品")
    @GetMapping("/selectproduct")
    public Object selectproduct(Integer productId){
        return productService.selectProductByProductId(productId);
    }

}
