package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public String findName(int id, String itheima) {
        System.out.println("id = " + id);
        if (true) throw new NullPointerException();
        return "itcast";
    }
}
