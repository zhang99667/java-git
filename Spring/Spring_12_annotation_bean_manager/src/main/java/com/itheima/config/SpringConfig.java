package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.itheima.dao", "com.itheima.service"})
public class SpringConfig {
}
