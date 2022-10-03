package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo3")
public class ServletDemo3 extends MyServletHttp {
    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        super.doGet(servletRequest, servletResponse);
        System.out.println("get...");
    }

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        super.doPost(servletRequest, servletResponse);
        System.out.println("post...");
    }
}
