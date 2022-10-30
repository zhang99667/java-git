package com.itheima.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private Object data;
    private String msg;

    /* 先码值再数据，这是一种习惯 */
    public Result(Integer code, Object data) {
        this.code = code;
        this.msg = msg;
    }
}
