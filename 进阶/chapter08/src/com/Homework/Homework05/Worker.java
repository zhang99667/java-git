package com.Homework.Homework05;

public class Worker extends Employee {

    // 工人，农民，服务生只有基本工资
    public Worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        System.out.print("工人：");
        super.printSal();
    }

}
