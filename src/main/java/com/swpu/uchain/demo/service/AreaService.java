package com.swpu.uchain.demo.service;

import com.swpu.uchain.demo.form.AreaForm;
import com.swpu.uchain.demo.vo.ResultVO;
import com.swpu.uchain.demo.entity.Area;

public interface AreaService {

    boolean delete(Integer areaId);

    boolean update(Area area);

    boolean insert(Area area);

    ResultVO updateArea(Area area);

    ResultVO selectAllArea();

    ResultVO selectByAreaId(Integer areaId);

    ResultVO deleteByAreaId(Integer areaId);

    ResultVO insertArea(AreaForm areaForm);

}
