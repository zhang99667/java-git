package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/*
 * 中文乱码问题解决方案
 *  */
@WebServlet("/req3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 解决乱码：POST，getReader()
        req.setCharacterEncoding("UTF-8"); // 设置字符输入流编码

        // 2. 获取 username
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("解决乱码前：" + username);

        // 3. 解决乱码：GET，获取参数方式：getQueryString
        // 乱码原因：Tomcat 进行 URL 解码，默认字符集为 ISO-8895-1
        // 3.1 先对乱码数据进行编码：转换为字节数组
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        // 3.2 字节数组解码
        username = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("解决乱码后：" + username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}