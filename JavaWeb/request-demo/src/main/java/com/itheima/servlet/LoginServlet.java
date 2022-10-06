package com.itheima.servlet;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        // 2. 调用 MyBatis 完成查询
        // 2.1 获取 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        // 2.2 获取 SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2.3 获取 Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 2.4 调用方法
        User userInfo = userMapper.getUserInfo(username, password);
        // 2.5 释放资源
        sqlSession.close();

        // 前端显示
        // 获取字符输出流，并设置 content type
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        // 3. 判断 user 释放为 null
        if (userInfo != null) {
            // 登陆成功
            writer.write("登陆成功");
            System.out.println("success");
        } else {
            // 登陆失败
            writer.write("登陆失败");
            System.out.println("failed");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}