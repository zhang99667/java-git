package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        if (!(bookService.save(book))) return new Result(Code.SAVE_ERR, "保存失败");
        return new Result(Code.SAVE_OK, book);

    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        if (!(bookService.update(book))) return new Result(Code.UPDATE_ERR, "更新失败");
        return new Result(Code.UPDATE_OK, book);

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (!(bookService.delete(id))) return new Result(Code.DELETE_OK);
        return new Result(Code.DELETE_ERR, "删除失败");

    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        Book book = bookService.selectById(id);
        if (book == null) return new Result(Code.GET_ERR, "获取失败");
        return new Result(Code.GET_OK, book);
    }

    @GetMapping
    public Result selectAll() {
        List<Book> books = bookService.selectAll();
        if (books == null) return new Result(Code.GET_ERR, "获取失败");
        return new Result(Code.GET_OK, books);
    }
}
