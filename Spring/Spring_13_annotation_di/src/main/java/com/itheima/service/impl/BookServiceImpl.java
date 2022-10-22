package com.itheima.service.impl;

import com.itheima.service.BookService;
import com.itheima.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    @Qualifier("bookDao2")
    private BookDao bookDao;


    // @Value("itheima123")
    @Value("${name}")
    private String name;

    @Override
    public void save() {
        bookDao.save();
        System.out.println("name = " + name);
    }
}