package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String getMethod()：获取请求方法：GET
        String method = req.getMethod();
        System.out.println(method);
        // String getContextPath():获取虚拟目录（项目访问路径）：/request-demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        // StringBuffer getRequestURL():获取URL(统一资源定位符)：http://localhost:8080/request-demo/reg1
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        // String getRequestURI():获取URI(统一资源标识符)：/request-demo/reql
        String uri = req.getRequestURI();
        System.out.println(uri);
        // string getQueryString():获取请求参数(GET方式)：username=zhangsan
        String queryString = req.getQueryString();
        System.out.println(queryString);

        // ----------
        // 获取请求头：user-agent：获取浏览器版本信息
        String agent = req.getHeader("user-agent");
        System.out.println(agent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
        // 获取 post 请求体：请求参数
        // 1. 获取字符输入流
        BufferedReader bf = req.getReader();
        // 2. 读取数据
        String line = bf.readLine();
        System.out.println(line);
    }
}