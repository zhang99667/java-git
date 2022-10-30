package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProjectAdvice {

    // 匹配业务层所有接口
    @Pointcut("execution(* com.itheima.service.*Service.*(..))")
    private void servicePt() {
    }

    @Around("ProjectAdvice.servicePt()")
    public void runSpeed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            if (i % 100 == 0)
                System.out.println(i / 100 + "%");
            if (i == 9999)
                System.out.println("100%");
            proceedingJoinPoint.proceed();
        }
        Long endTime = System.currentTimeMillis();
        Long totalTime = endTime - startTime;
        System.out.println("当前类型：" + signature.getDeclaringType());
        System.out.println("当前方法：" + signature.getName());
        System.out.println("业务层接口万次执行时间：" + totalTime + "ms");
    }
}