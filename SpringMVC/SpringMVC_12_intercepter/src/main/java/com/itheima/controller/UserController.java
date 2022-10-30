package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    // 设置当前请求方法为POST，表示REST风格中的添加操作
    @PostMapping
    public String save(@RequestBody User user) {
        System.out.println("user save...");
        return "{'module':'user save'}";
    }

    // 设置当前请求方法为DELETE，表示REST风格中的删除操作
    // @PathVariable注解用于设置路径变量（路径参数），要求路径上设置对应的占位符，并且占位符名称与方法形参名称相同
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("user delete..." + id);
        return "{'module':'user delete'}";
    }

    // 设置当前请求方法为PUT，表示REST风格中的修改操作
    @PutMapping
    public String update(@RequestBody User user) {
        System.out.println("user update..." + user);
        return "{'module':'user update'}";
    }

    // 设置当前请求方法为GET，表示REST风格中的查询操作
    // @PathVariable注解用于设置路径变量（路径参数），要求路径上设置对应的占位符，并且占位符名称与方法形参名称相同
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println("user getById..." + id);
        return "{'module':'user getById'}";
    }

    // 设置当前请求方法为GET，表示REST风格中的查询操作
    @GetMapping
    public String getAll() {
        System.out.println("user getAll...");
        return "{'module':'user getAll'}";
    }
}