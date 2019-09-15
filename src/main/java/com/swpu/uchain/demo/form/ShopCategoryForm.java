package com.swpu.uchain.demo.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ShopCategoryForm {

    @NotNull(message = "商铺种类编号不能为空")
    @ApiModelProperty("商铺种类编号")
    private Integer shopCategoryId;

    @NotNull(message = "商铺种类名称不能为空")
    @ApiModelProperty("商铺种类名称")
    private String shopCategoryName;

    @ApiModelProperty("商铺种类描述")
    private String shopCategoryDesc;
}
