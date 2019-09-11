package com.swpu.uchain.demo.controller;

import com.swpu.uchain.demo.entity.Shop;
import com.swpu.uchain.demo.form.ShopForm;
import com.swpu.uchain.demo.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author EmiYkr
 * @date 2019-9-8
 */
@RestController
@RequestMapping("/shop")
@Api(tags = "商铺管理")
@ControllerAdvice
public class ShopController {
    @Autowired
    private ShopService shopService;

    @ApiOperation("创建商铺")
    @PostMapping("/insertshop")
    public Object insertshop(@Valid ShopForm shopForm){
        return shopService.insertShop(shopForm);
    }

    @ApiOperation("删除商铺")
    @GetMapping("/deleteshop")
    public Object deleteshop(Integer shopId){
        return shopService.deleteShop(shopId);
    }

    @ApiOperation("修改商铺信息")
    @PostMapping("/updateshop")
    public Object updateshop(@Valid Shop shop){
        return shopService.updateShop(shop);
    }

    @ApiOperation("产看商铺详情")
    @GetMapping("/findshop")
    public Object findshop(Integer ownerId){
        return shopService.selectShop(ownerId);
    }

}
