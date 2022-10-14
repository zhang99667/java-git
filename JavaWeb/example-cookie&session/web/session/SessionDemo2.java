package com.itheima.webservlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/SessionDemo1")
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取数据，从 Session 中获取
        // 1. 获取 Session 对象
        HttpSession session = request.getSession();
        // 2. 获取数据
        Object username = session.getAttribute("username");
        System.out.println(username);
        // 销毁
        session.invalidate(); // 可以在退出登陆的时候使用
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
