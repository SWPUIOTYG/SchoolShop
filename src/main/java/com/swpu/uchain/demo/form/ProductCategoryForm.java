package com.swpu.uchain.demo.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductCategoryForm {

    @NotNull(message = "商品类型名不能为空")
    @ApiModelProperty("商品类型名")
    private String productCategoryName;

    @NotNull(message = "商铺编号不能为空")
    @ApiModelProperty("商铺编号")
    private Integer shopId;
}