package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.itheima.dao", "com.itheima.aop"})
@EnableAspectJAutoProxy
public class SpringConfig {
}