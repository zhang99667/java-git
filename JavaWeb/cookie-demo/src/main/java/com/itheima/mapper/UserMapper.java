package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return List<User> 实体
     */
    List<User> selectAll();

    /**
     * 根据 username 查询用户
     *
     * @param username 用户名
     * @return User 实体
     */
    User selectUserByUsername(@Param("username") String username);


    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return User 实体
     */
    User login(@Param("username") String username, @Param("password") String password);


    /**
     * 用户注册
     *
     * @param user 传递实体
     */
    void register(User user);
}
