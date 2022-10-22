package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {
    private String name;

    @Override
    public void save() {
        System.out.println("save..." + this.getName());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
