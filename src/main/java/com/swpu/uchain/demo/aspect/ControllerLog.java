package com.swpu.uchain.demo.aspect;

import com.swpu.uchain.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ControllerLog {
    @Pointcut("execution(public * com.swpu.uchain.demo.controller.*.*(..))")
    public void controller(){}

    @Before("controller()")
    public void before(JoinPoint joinPoint){
        Signature signature=joinPoint.getSignature();
        String method=signature.getDeclaringTypeName() + "." +signature.getName();
        log.info("-------------------------------------------------------------");
        log.info("当前执行的controller方法:  "+method);
        Object[] args=joinPoint.getArgs();
        for(Object arg:args){
            log.info("参数:  "+arg);
        }
    }

    @AfterReturning(pointcut = "controller()",returning = "ret")
    public void after(Object ret){
        ResultVO resultVO=(ResultVO) ret;
        if(resultVO != null && resultVO.getCode() !=0){
            log.error(resultVO.getMsg());
        }
        log.info("controller返回的参数: "+resultVO);
        log.info("--------------------------------------------------------------");
    }
}
