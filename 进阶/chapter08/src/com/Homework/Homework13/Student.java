package com.Homework.Homework13;

public class Student extends Person {
    private int stuID;

    // 构造方法
    public Student(String name, char gender, int age, int stuID) {
        super(name, gender, age);
        this.setStuID(stuID);
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    // 特有方法
    public void study() {
        System.out.println("我承诺，我会好好学习。");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    @Override
    public void printInfo() {
        System.out.println("学生的信息：");
        super.printInfo();
        System.out.println("学号：" + this.getStuID());
        this.study();
        System.out.println(this.play());
    }
}
