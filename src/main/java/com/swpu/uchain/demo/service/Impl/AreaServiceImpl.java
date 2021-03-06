package com.swpu.uchain.demo.service.Impl;
import com.swpu.uchain.demo.entity.Area;
import com.swpu.uchain.demo.dao.AreaMapper;
import com.swpu.uchain.demo.enums.ResultEnum;
import com.swpu.uchain.demo.form.AreaForm;
import com.swpu.uchain.demo.service.AreaService;
import com.swpu.uchain.demo.util.ResultVOUtil;
import com.swpu.uchain.demo.vo.ResultVO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author EmiYkr
 * @description 区域管理
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public boolean delete(Integer areaId) {
        return areaMapper.deleteByPrimaryKey(areaId)==1;
    }


    @Override
    public boolean update(Area area) {
        return areaMapper.updateByPrimaryKey(area)==1;
    }

    @Override
    public boolean insert(Area area) {
        return areaMapper.insert(area)==1;
    }

    @Override
    public ResultVO updateArea(Area area) {
        if(areaMapper.selectByPrimaryKey(area.getAreaId())== null){
            return ResultVOUtil.error(ResultEnum.AREA_NOT_EXIST);
        }
        area.setLastEditTime(new Date());
        if(areaMapper.updateByPrimaryKey(area)==1){
            return ResultVOUtil.success(area);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO selectAllArea() {
        List<Area> areaList=areaMapper.selectAll();
        return ResultVOUtil.success(areaList);
    }

    @Override
    public ResultVO selectByAreaId(Integer areaId) {
        if(areaMapper.selectByPrimaryKey(areaId)==null){
            return ResultVOUtil.error(ResultEnum.AREA_NOT_EXIST);
        }
        Area area=areaMapper.selectByPrimaryKey(areaId);
        if(area!=null){
            return ResultVOUtil.success(area);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO deleteByAreaId(Integer areaId) {
        if(areaMapper.selectByPrimaryKey(areaId)==null){
            return ResultVOUtil.error(ResultEnum.AREA_NOT_EXIST);
        }
        if(delete(areaId)){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @Override
    public ResultVO insertArea(AreaForm areaForm) {
        if(areaMapper.selectByAreaName(areaForm.getAreaName())!=null){
            return ResultVOUtil.error(ResultEnum.AREA_ALREADY_EXIST);
        }
        Date date =new Date();
        Area area=new Area();
        area.setCreateTime(date);
        area.setLastEditTime(date);
        BeanUtils.copyProperties(areaForm,area);
        if(insert(area)){
            return ResultVOUtil.success(area);
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }
}
