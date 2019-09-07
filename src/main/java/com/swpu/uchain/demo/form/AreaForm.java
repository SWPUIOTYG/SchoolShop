package com.swpu.uchain.demo.form;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AreaForm {

    @NotNull(message = "区域ID不能为空")
    @ApiModelProperty("区域ID")
    private String areaId;

    @NotNull(message = "区域名称不能为空")
    @ApiModelProperty("区域名称")
    private String areaName;

    @NotNull(message = "区域创建时间不能为空")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @NotNull(message = "权重不能为空")
    @ApiModelProperty("权重")
    private Integer priority;


}
