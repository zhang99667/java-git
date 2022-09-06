package com.Homework.Homework05;

public class Teacher extends Employee {
    // 特有属性
    private int classDay; // 上课天数
    private double classSal; // 课时费

    public Teacher(String name, double salary, int classDay, double classSal) {
        super(name, salary);
        this.setClassDay(classDay);
        this.setClassSal(classSal);
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void printSal() {
        System.out.print("老师：");
        System.out.println(this.getName() + "年工资是：" + (this.getClassSal() * this.getClassDay() + this.getSalary() * this.getSalMonth()));
    }
}
