package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    private BookDao bookDao;

    public void setBookDao(BookDaoImpl bookDao) {
        System.out.println("set...");
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        bookDao.save();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init");
    }
}