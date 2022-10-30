package com.itheima.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"com.itheima.mapper","com.itheima.service","com.itheima.aop"})
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@Import({JdbcConfig.class,MybatisConfig.class})
public class SpringConfig {
}