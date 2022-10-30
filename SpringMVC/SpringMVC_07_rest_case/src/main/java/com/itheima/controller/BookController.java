package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("book = " + book);

        return "{'module':'book save success'}";
    }

    @GetMapping
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("计算机", "SpringMVC入门课程", "小试牛刀");
        Book book2 = new Book("计算机", "SpringMVC实战课程", "小试牛刀");
        bookList.add(book1);
        bookList.add(book2);
        return bookList;
    }
}