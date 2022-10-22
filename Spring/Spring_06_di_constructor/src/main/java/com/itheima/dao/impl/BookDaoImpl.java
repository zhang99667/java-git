package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {
    private int connectionNum;

    public BookDaoImpl(int connectionNum, String databaseName) {
        this.connectionNum = connectionNum;
        this.databaseName = databaseName;
    }

    private String databaseName;

    @Override
    public void save() {
        System.out.println("[BookDao] save..." + databaseName + "," + connectionNum);
    }
}