package com.itheima.exception;

import lombok.Data;

@Data
public class SystemException extends RuntimeException {
    // 异常编号
    private Integer code;

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}