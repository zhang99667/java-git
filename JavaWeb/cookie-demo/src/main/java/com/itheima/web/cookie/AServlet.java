package com.itheima.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 发送 Cookie

        // 1. 创建 Cookie 对象
        Cookie cookie = new Cookie("username", "zhangsan");
        String value = "张三"; // 中文需要转码
        // 1.1 设置存活时间
        cookie.setMaxAge(60 * 60 * 24 * 7); // 7 天

        value = URLEncoder.encode(value, "UTF-8");
        Cookie cookie1 = new Cookie("username-Chinese", value);
        // 2. 发送 Cookie，response
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}