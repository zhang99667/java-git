package com.atguigu.eduService.controller;


import com.atguigu.commonUtils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduService/user")
@CrossOrigin // 解决跨域
public class EduLoginController {

    // login
    @PostMapping("login")
    public R login() {

        // redis  mysql

        // 数据,jwt json web token
        // 加密 token


        //

        return R.ok().data("token", "admin");
    }

    // getInfo
    @GetMapping("info")
    public R info() {
        // token 解密


        //


        // getway
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}

