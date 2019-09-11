package com.swpu.uchain.demo.aspect;

import com.swpu.uchain.demo.util.ResultVOUtil;
import com.swpu.uchain.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author EmiYkr
 * 处理表单验证中的空值的情况
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleValidException(MethodArgumentNotValidException e){
        log.error(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return ResultVOUtil.error(103,e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
