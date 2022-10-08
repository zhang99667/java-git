package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {

    /*
     * 查询所有
     *  */
    public List<User> selectAll() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        sqlSession.close(); // 关闭会话
        return users;
    }

    /*
     * 登陆
     *  */
    public boolean login(String username, String password) {
        // 获取 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取 userMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.login(username, password);

        sqlSession.close(); // 关闭会话

        if (user == null) {
            System.out.println("用户不存在");
            return true;
        } else {
            System.out.println("登陆成功");
            return false;
        }
    }
}