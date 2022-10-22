package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        bookDao.save();
    }
}