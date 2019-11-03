package com.swpu.uchain.demo.controller;

import com.swpu.uchain.demo.form.AreaForm;
import com.swpu.uchain.demo.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.swpu.uchain.demo.entity.Area;

import javax.validation.Valid;

/**
 * @author EmiYkr
 */

@RestController
@Api(tags = "区域管理")
@RequestMapping("/area")
@ControllerAdvice
public class AreaController {

    @Autowired
    private AreaService areaService;

    @ApiOperation("添加区域信息")
    @PostMapping("/addArea")
    public Object addArea(@Valid AreaForm areaForm){
        return areaService.insertArea(areaForm);
    }

    @ApiOperation("删除区域信息")
    @GetMapping("/deleteArea")
    public Object deleteArea(@Valid Integer areaId){
        return areaService.deleteByAreaId(areaId);
    }

    @ApiOperation("修改区域信息")
    @PostMapping("/updateArea")
    public Object updateArea(@Valid Area area){
        return areaService.updateArea(area);
    }

    @ApiOperation("查找区域信息")
    @GetMapping("/findArea")
    public Object findArea(@Valid Integer areaId){
        return areaService.selectByAreaId(areaId);
    }

    @ApiOperation("查找所有区域信息")
    @GetMapping("/findAllArea")
    public Object findAllArea(){
        return areaService.selectAllArea();
    }
}
