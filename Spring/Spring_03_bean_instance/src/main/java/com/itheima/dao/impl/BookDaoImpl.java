package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {
    // 构造方法
    // 也可以调用私有的方法（反射）
    // Spring 调用的是无参的构造方法
    private BookDaoImpl() {
        System.out.println("book dao constructor is running ....");
    }

    public void save() {
        System.out.println("book dao save ...");
    }
}