package com.itheima.service.impl;

import com.itheima.service.BookService;
import com.itheima.dao.BookDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class BookServiceImpl implements BookService {
    BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        bookDao.save();
    }

    @PostConstruct // 构造方法后运行的方法
    public void init() {
        System.out.println("init...");
    }

    @PreDestroy // 销毁前运行的方法
    public void destory() {
        System.out.println("destory...");
    }
}
