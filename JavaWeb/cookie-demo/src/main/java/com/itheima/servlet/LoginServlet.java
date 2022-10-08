package com.itheima.servlet;

import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2. 调用 service 查询
        boolean login = userService.login(username, password);
        // 判断是否登陆成功
        if (login) {
            response.getWriter().write("登陆成功，" + username + "欢迎您");
            System.out.println("登陆成功");
        } else {
            response.getWriter().write("登陆失败");
            System.out.println("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}