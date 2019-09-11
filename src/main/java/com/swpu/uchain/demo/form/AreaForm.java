package com.swpu.uchain.demo.form;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description  管理员编辑区域信息
 */
@Data
public class AreaForm {

    @NotNull(message = "区域名称不能为空")
    @ApiModelProperty("区域名称")
    private String areaName;




}
