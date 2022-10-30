package com.itheima.controller;

import com.itheima.pojo.Address;
import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // 响应页面 / 跳转页面
    @RequestMapping("/toJumpPage")
    public String ToJumpPage() {
        System.out.println("跳转页面");
        return "page.jsp";
    }

    // 响应纯文本数据
    @RequestMapping("/toText")
    @ResponseBody
    public String toText() {
        System.out.println("返回纯文本数据");
        return "response text";
    }

    // 响应 POJO 对象
    @RequestMapping("/toJsonPOJO")
    @ResponseBody
    public User toJsonPOJO() {
        System.out.println("返回 json 对象");
        User user = new User();
        user.setName("itcast");
        user.setAge(15);
        Address address = new Address("Beijing", "Beijing");
        user.setAddress(address);
        return user;
    }

    // 响应 POJO 集合类型
    @RequestMapping("/toJsonList")
    @ResponseBody
    public List<User> toJsonList() {
        System.out.println("返回 json 集合数据");
        Address address = new Address("Beijing", "Beijing");
        User user1 = new User("传智播客", 15, address);
        User user2 = new User("黑马程序员", 12, address);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        return userList;
    }


}