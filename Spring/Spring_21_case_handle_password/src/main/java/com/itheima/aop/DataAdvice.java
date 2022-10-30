package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataAdvice {
    @Pointcut("execution(boolean com.itheima.service.ResourcesService.openURL(..))")
    private void servicePt() {
    }

    @Around("DataAdvice.servicePt()")
    public Object trimStr(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            // 判断参数是不是字符串
            if (args[i].getClass().equals(String.class)) {
                // 截取中间的字符串
                args[i] = args[i].toString().trim();
            }
        }

        Object ret = proceedingJoinPoint.proceed(args);
        return ret;
    }
}