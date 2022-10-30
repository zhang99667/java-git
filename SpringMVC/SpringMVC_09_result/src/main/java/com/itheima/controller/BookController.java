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
        Result result = new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
        return result;
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        Result result = new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean flag = bookService.delete(id);
        Result result = new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
        return result;
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable int id) {
        Book book = bookService.selectById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR; // 状态码
        String msg = book != null ? "查询成功" : "数据查询失败，请重试！"; // 错误信息
        Object data = book; // 数据
        Result result = new Result(code, book, msg);
        return result;
    }

    @GetMapping
    public Result selectAll() {
        List<Book> bookList = bookService.selectAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "查询成功" : "数据查询失败，请重试！";
        Object data = bookList;
        Result result = new Result(code, data, msg);
        return result;
    }
}
