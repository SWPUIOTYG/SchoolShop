package com.swpu.uchain.demo.form;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.rmi.MarshalException;
import java.util.Date;

@Data
public class ProductForm {

    @ApiModelProperty("商品名称")
    @NotNull(message = "商品名称不能为空")
    private String productName;

    @ApiModelProperty("商品描述")
    private String productDesc;

    @ApiModelProperty("商品原价")
    @NotNull(message = "商品原价不能为空")
    private String normalPrice;

    @ApiModelProperty("折扣价")
    private String promotionPrice;

    @ApiModelProperty("商品类别序号")
    @NotNull(message = "商品类别序号不能为空")
    private Integer productCategoryId;

    @ApiModelProperty("商店编号")
    @NotNull(message = "商铺编号不能为空")
    private Integer shopId;
}
