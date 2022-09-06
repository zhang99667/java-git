package com.Homework.Homework05;

public class Scientist extends Employee {
    private double Bounds; // 年终奖

    // 全参构造器
    public Scientist(String name, double salary, int salMonth, double bounds) {
        super(name, salary, salMonth);
        this.setBounds(bounds);
    }

    public double getBounds() {
        return Bounds;
    }

    public void setBounds(double bounds) {
        Bounds = bounds;
    }

    @Override
    public void printSal() {
        System.out.print("科学家：");
        System.out.println(this.getName() + "年工资是" + (this.getSalary() * this.getSalMonth() + this.getBounds()));
    }
}
