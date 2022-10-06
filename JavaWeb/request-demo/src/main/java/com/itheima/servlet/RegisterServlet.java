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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收注册信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 2. 调用 MyBatis 完成注册
        // 2.1 获取 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        // 2.2 获取 SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2.3 获取 Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 2.4 调用方法
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            userMapper.register(username, password);
            sqlSession.commit();
            System.out.println("注册成功");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("用户名已存在");
            System.out.println("用户名已存在");
        }
        // 2.5 释放资源
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
