package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.itheima.controller")
// 开启自动转换 json 数据的支持
@EnableWebMvc
public class SpringMvcConfig {
}