package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("dao save...");
    }

    /**
     * 表示 bean 初始化对应的操作
     */
    public void init(){
        System.out.println("init");
    }

    /**
     * 表示 bean 销毁前对应的操作
     */
    public void destory(){
        System.out.println("destory");
    }
}