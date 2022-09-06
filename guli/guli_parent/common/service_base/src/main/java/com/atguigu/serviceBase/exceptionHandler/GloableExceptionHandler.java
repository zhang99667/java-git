package com.atguigu.serviceBase.exceptionHandler;


import com.atguigu.commonUtils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
// 全局异常处理
public class GloableExceptionHandler {

    // 指定出现什么异常时执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody // 为了返回数据
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理...");
    }


    // 特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody // 为了返回数据
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理...");
    }

    // 自定义异常
    @ExceptionHandler(GuliException.class)
    @ResponseBody // 为了返回数据
    public R error(GuliException e) {
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}

