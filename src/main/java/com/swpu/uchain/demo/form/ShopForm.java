package com.swpu.uchain.demo.form;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @description 店家增加店铺信息
 */
@Data
public class ShopForm {
//    @NotNull(message = "商铺Id不能为空")
//    @ApiModelProperty("商铺Id")
//    private Integer shopId;

    @NotNull(message = "店家Id不能为空")
    @ApiModelProperty("店家Id")
    private Integer ownerId;

    @NotNull(message = "店家姓名不能为空")
    @ApiModelProperty("店家姓名")
    private String ownerName;

    @NotNull(message = "区域Id不能为空")
    @ApiModelProperty("区域Id")
    private Integer areaId;

    @NotNull(message = "商铺类型编号不能为空")
    @ApiModelProperty("商铺类别")
    private Integer shopCategoryId;

    @NotNull(message = "商铺名称不能为空")
    @ApiModelProperty("商铺名称")
    private String shopName;

    @ApiModelProperty("商铺描述")
    private String shopDesc;

    @NotNull(message = "商铺地址不能为空")
    @ApiModelProperty("商铺地址")
    private String shopAddr;;

    @ApiModelProperty("店家手机号")
    @NotNull(message = "店家手机号不能为空")
    private String phone;

}
