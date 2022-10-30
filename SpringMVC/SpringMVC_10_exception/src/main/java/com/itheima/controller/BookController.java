package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable int id) {
        Book book = bookService.selectById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        // 扔出异常
        int i = 1 / 0;
        Object data = book;
        String msg = book != null ? "查询成功" : "查询失败，请稍后重试";
        return new Result(code, data, msg);
    }

    @GetMapping
    public Result selectAll() {
        List<Book> books = bookService.selectAll();
        Integer code = books != null ? Code.GET_OK : Code.GET_ERR;
        Object data = books;
        String msg = books != null ? "查询成功" : "查询失败，请稍后重试";
        return new Result(code, data, msg);
    }
}