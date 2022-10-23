package com.itheima.service;

import com.itheima.pojo.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> selectAll();

    User selectById(int id);

    void delete(int id);

    void update(User user);
}