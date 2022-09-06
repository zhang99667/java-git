package com.atguigu.serviceBase.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 用lombok生成有参构造器
@NoArgsConstructor // 用lombok生成无参构造器
public class GuliException extends RuntimeException
{
    private Integer code; // 状态码

    private String msg; // 异常信息

}
