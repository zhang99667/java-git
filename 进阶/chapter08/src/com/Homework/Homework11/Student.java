package com.Homework.Homework11;

public class Student extends Person {
    private int stu_id;

    public Student(String name, int age, int stu_id) {
        super(name, age);
        this.setStu_id(stu_id);
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    // 重写 run 方法
    public void run() {
        System.out.println("student run");
    }

    // 特有方法
    public void study() {
        System.out.println("student study..");
    }
}
