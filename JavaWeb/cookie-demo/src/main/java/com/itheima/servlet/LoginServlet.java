package com.itheima.servlet;

import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 获取复选框数据
        String remember = request.getParameter("remember");

        // 2. 调用 service 查询
        boolean login = userService.login(username, password);
        // 获取字符输出流，并设置 content type
        response.setContentType("text/html;charset=utf-8");
        // 判断是否登陆成功
        System.out.println(login);
        if (login) {
            // 判断是否勾选记住密码
            if ("on".equals(remember)) {
                // 发送 Cookie
                // 1. 创建 Cookie 对象
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                // 设置 Cookie 存活时间
                c_username.setMaxAge(60 * 60 * 24 * 7);
                c_password.setMaxAge(60 * 60 * 24 * 7);
            }
            response.getWriter().write("登陆成功，" + username + " 欢迎您");

            System.out.println("登陆成功");
        } else {
            response.getWriter().write("登陆失败");
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    response.getWriter().write("</br>username:" + cookie.getValue());
                if("password".equals(cookie.getName()))
                    response.getWriter().write("password:" + cookie.getValue());
                }
            }
            System.out.println("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}