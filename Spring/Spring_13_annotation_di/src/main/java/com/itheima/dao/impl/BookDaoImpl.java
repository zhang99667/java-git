package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("bookDao1 - save...");
    }
}
