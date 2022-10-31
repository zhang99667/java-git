package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {
        return new Result(Code.SYSTEM_ERR, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        return new Result(Code.BUSINESS_ERR, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        return new Result(Code.SYSTEM_UNKNOW_ERR,"系统繁忙，稍后重试");
    }
}
