package com.itheima.aop;

import com.itheima.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(void com.itheima.dao.*Dao.save())")
    private void aroundPointcut() {
    }

    @Around("aroundPointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before");
        pjp.proceed();
        System.out.println("after");
        // 记录程序当前执行时间（开始时间）
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            // 执行 BookDao.save() 方法
            // 表示对原始操作的调用
            pjp.proceed();
        }
        // 记录程序当前执行时间（结東时间）》
        Long endTime = System.currentTimeMillis();
        // 计算时间差
        Long totalTime = endTime - startTime;
        // 输出信息
        System.out.println("执行万次消耗时间：" + totalTime + "ms");
    }

    @Pointcut("execution(void com.itheima.dao.*Dao.*Id(*))")
    private void aroundUserDao() {
    }

    @Around("aroundUserDao()")
    public Object aroundDaoReturnUser(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before selectById");
        User ret = (User) pjp.proceed();
        System.out.println("after selectById");
        return ret;
    }
}