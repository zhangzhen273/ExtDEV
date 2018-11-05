package com.ext.common.aop;

import com.ext.common.domain.dto.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAop {

    /**
     * 操作日志切入点
     */
    @Pointcut("@annotation(com.ext.common.annotations.OperationLogAnnotation)")
    public void operationLogPointCut() {

    }

    @Around("operationLogPointCut()")
    public Object twiceAsOld(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        thisJoinPoint.getArgs();
        Result thing = (Result) thisJoinPoint.proceed();
        return thing;
    }

}
