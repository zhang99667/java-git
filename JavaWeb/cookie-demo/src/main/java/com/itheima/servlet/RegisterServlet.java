package com.itheima.servlet;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/registerServlet")

public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取用户名和密码和验证码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        String checkCodeGen = null;

        // 程序生成的验证码，从 Session 中获取
        // HttpSession session = request.getSession();
        // String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            if (cookie.getName().equals("checkCodeGen")) {
                System.out.println(cookie.getValue());
                 checkCodeGen = cookie.getValue();
            }
        }

        // 新建用户
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        response.setContentType("text/html;charset=utf-8");

        if (!checkCodeGen.equalsIgnoreCase(checkCode))
            response.getWriter().write("验证码输入有误！");

        if (userService.register(user)) {
            System.out.println("注册成功");
            request.getRequestDispatcher("/login.html").forward(request, response); // 跳转登录界面
        } else {
            System.out.println("用户名和密码已存在");
            response.getWriter().write("用户名和密码已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}