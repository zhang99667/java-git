package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 拦截路径
@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 放行前，对 request 数据进行处理
        System.out.println("FilterDemo1：执行放行前逻辑");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        // 2. 放行后，对 Response 数据进行处理
        System.out.println("FilterDemo4：执行放行后逻辑");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
