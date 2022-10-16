package com.itheima.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonDemo {
    public static void main(String[] args) {
        // 1. 将 Java 对象转换为 Json 字符串
        User user = new User();
        user.setId(1);
        user.setUsername("zhagnsan");
        user.setPassword("123");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString); // {"id":1,"password":"123","username":"zhagnsan"}

        // 2. 将 Json 字符串 转为 Java 对象
        User jsonObject = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhagnsan\"}", User.class);
        System.out.println(jsonObject);


    }
}
