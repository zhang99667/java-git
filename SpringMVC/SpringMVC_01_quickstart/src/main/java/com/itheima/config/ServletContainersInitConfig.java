package com.itheima.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// 4. 定义一个 Servlet 容器启动的配置类，在里面加载 spring 的配置
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {

    // 加载 springmvc 容器配置
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        // 初始化一个 web 专用的 applicationContext
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    // 设置那些请求归属 springmvc 处理
    @Override
    protected String[] getServletMappings() {
        // 所有请求
        return new String[]{"/"};
    }

    // 加载 spring 容器配置
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}