package com.itheima.controller;


import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截到系统异常
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex) {
        System.out.println("捕获到系统异常");
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    // 拦截业务异常
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex) {
        System.out.println("捕获到业务异常");
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    // 拦截其他异常
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        System.out.println("捕获到其他异常");
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR, null, "系统繁忙，稍后重试");
    }
}
