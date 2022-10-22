package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import lombok.Data;

import java.util.*;

@Data
public class BookDaoImpl implements BookDao {

    private int[] array;

    private List<String> list;

    private Set<String> set;

    private Map<String,String> map;

    private Properties properties;

    @Override
    public void save() {
        System.out.println("save...");

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        System.out.println("list = " + list);

        System.out.println("set = " + set);

        System.out.println("map = " + map);

        System.out.println("properties = " + properties);

    }
}
