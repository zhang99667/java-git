package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Hello world!
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ossApplication {
    public static void main(String[] args) {
        // 创建启动类
        SpringApplication.run(ossApplication.class, args);
        System.out.println("started...");
    }
}
