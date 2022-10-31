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
    private String msgSuc = "操作成功";
    private String msgErr = "操作失败，稍后重试";

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        String msg = flag ? msgSuc : msgErr;
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, msg);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        String msg = flag ? msgSuc : msgErr;
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, msg);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean flag = bookService.delete(id);
        String msg = flag ? msgSuc : msgErr;
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, msg);
    }


    @GetMapping("/{id}")
    public Result selectById(@PathVariable int id) {
        Book book = bookService.selectById(id);
        String msg = book != null ? msgSuc : msgErr;
        return new Result(book != null ? Code.GET_OK : Code.GET_ERR, book, msg);
    }

    @GetMapping
    public Result selectAll() {
        List<Book> books = bookService.selectAll();
        String msg = books != null ? msgSuc : msgErr;
        return new Result(books != null ? Code.GET_OK : Code.GET_ERR, books, msg);
    }
}
