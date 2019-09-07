package com.swpu.uchain.demo.controller;

import com.swpu.uchain.demo.form.AreaForm;
import com.swpu.uchain.demo.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swpu.uchain.demo.entity.Area;

/**
 * @author EmiYkr
 */

@RestController
@Slf4j
@Api(tags = "区域管理")
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @ApiOperation("添加区域信息")
    @PostMapping("/addArea")
    public Object addArea(AreaForm areaForm){
        return areaService.insertArea(areaForm);
    }

    @ApiOperation("删除区域信息")
    @GetMapping("/deleteArea")
    public Object deleteArea(Integer areaId){
        return areaService.deleteByAreaId(areaId);
    }

    @ApiModelProperty("修改区域信息")
    @PostMapping("/updateArea")
    public Object updateArea(Area area){
        return areaService.updateArea(area);
    }

    @ApiModelProperty("查找区域信息")
    @GetMapping("/findArea")
    public Object findArea(Integer areaId){
        return areaService.selectByAreaId(areaId);
    }

    @ApiOperation("查找所有区域信息")
    @GetMapping("/findAllArea")
    public Object findAllArea(){
        return areaService.selectAllArea();
    }
}
