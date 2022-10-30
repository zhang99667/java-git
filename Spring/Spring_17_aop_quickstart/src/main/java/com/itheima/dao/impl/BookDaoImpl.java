package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        // 记录程序当前执行时间（开始时间）
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println("save...");
        }
        // 记录程序当前执行时间（结東时间）》
        Long endTime = System.currentTimeMillis();
        // 计算时间差
        Long totalTime = endTime - startTime;
        // 输出信息
        System.out.println("执行万次消耗时间：" + totalTime + "ms");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void select() {
        System.out.println("select");
    }
}
