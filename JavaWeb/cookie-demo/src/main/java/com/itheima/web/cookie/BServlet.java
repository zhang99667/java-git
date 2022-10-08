package com.itheima.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 Cookie

        // 1. 获取 Cookie 数组
        Cookie[] cookies = req.getCookies();

        // 2. 遍历数组
        for (Cookie cookie : cookies) {
            // 3. 获取数据
            String name = cookie.getName();
            if ("username".equals(name)) {
                String value = cookie.getValue();
                System.out.println(name + ":" + value);
            }
            if ("username-Chinese".equals(cookie.getName())) {
                String value = cookie.getValue();
                value = URLDecoder.decode(value, "UTF-8");
                System.out.println(name + ":" + value);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}