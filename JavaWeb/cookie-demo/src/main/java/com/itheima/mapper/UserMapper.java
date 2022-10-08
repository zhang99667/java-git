package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> selectAll();


    /**
     * 根据 username 查询用户
     *
     * @param username 用户名
     * @return User
     */
    User selectUserByUsername(@Param("username") String username);

    User login(@Param("username") String username, @Param("password") String password);
}
