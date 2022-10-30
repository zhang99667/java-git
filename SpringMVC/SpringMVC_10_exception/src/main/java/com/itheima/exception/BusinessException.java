package com.itheima.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    // 异常代码
    private Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}