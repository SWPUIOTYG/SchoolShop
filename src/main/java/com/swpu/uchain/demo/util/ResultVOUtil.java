package com.swpu.uchain.demo.util;

import com.swpu.uchain.demo.enums.ResultEnum;
import com.swpu.uchain.demo.vo.ResultVO;
import lombok.Data;

@Data
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
       return success(null);
    }

    public static ResultVO error(ResultEnum resultenum){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(resultenum.getCode());
        resultVO.setMsg(resultenum.getMsg());
        return resultVO;

    }
}
