package com.Homework.Homework13;

public class Teacher extends Person {
    private int workAge;
    // 构造方法

    public Teacher(String name, char gender, int age, int workAge) {
        super(name, gender, age);
        this.setWorkAge(workAge);
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教学。");
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }

    @Override
    public void printInfo() {
        System.out.println("老师的信息：");
        super.printInfo();
        System.out.println("工龄：" + this.getWorkAge());
        this.teach();
        System.out.println(this.play());
    }
}
