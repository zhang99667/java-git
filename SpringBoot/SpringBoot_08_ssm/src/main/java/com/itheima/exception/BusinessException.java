package com.itheima.exception;

import lombok.Data;

@Data
public class BusinessException extends Exception{
    private Integer code;

    public BusinessException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }
}
