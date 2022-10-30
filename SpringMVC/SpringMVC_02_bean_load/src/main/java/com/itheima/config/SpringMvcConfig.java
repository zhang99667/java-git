package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// 3.创建 springmav 配置文件，加载 controller 对应的 bean
@Configuration
@ComponentScan("com.itheima.controller")
public class SpringMvcConfig {
}