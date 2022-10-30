package com.itheima.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    public Book(String type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
    }

    private String type;
    private Integer id;
    private String name;
    private String description;
}
