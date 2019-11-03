package com.swpu.uchain.demo.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HeadLineForm {

    @NotNull(message = "头条名称不能为空")
    @ApiModelProperty("头条名称")
    public String LineName;

    @ApiModelProperty("头条链接")
    @NotNull(message = "头条链接不能为空")
    public String LineLink;
}
