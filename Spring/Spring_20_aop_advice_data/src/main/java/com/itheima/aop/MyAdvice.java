package com.itheima.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.itheima.dao.BookDao.findName(..))")
    private void pt() {
    }

    // @Before("pt()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("before advice");
    }

    // @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("Arrays.toString(args) = " + Arrays.toString(args));
        // 拦截并修改值
        args[0] = 666;
        // 重新赋值参数
        Object proceed = proceedingJoinPoint.proceed(args);
        System.out.println("after");
        return proceed;
    }

    @AfterReturning(value = "pt()", returning = "ret")
    public void afterReturning(Object ret){
        // 接收返回值
        System.out.println("after Returning advice ret = " + ret);
    }

    @AfterThrowing(value = "pt()",throwing = "t")
    public void afterThrowing(Throwable t){
        System.out.println("afterThrowing advice...");
    }
}