package com.itheima.controller;


import com.itheima.domain.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${enterprise.name}")
    private String namne;

    @Value("${enterprise.subject[0]}")
    private String subject_0;

    @Autowired
    private Environment environment;

    @Autowired
    private Enterprise enterprise;

    @GetMapping("/{id}")
    public String selectById(@PathVariable Integer id){
        System.out.println("id = " + id);
        System.out.println("name = " + namne);
        System.out.println("environment.getProperty(\"enterprise.age\") = " + environment.getProperty("enterprise.age"));
        System.out.println("enterprise = " + enterprise);
        return "hello springboot";
    }
}
