package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    public Account(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(Integer id, Double money) {
        this.id = id;
        this.money = money;
    }

    public Account(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    private Integer id;
    private String name;
    private Double money;
}