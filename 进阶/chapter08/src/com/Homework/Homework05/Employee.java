package com.Homework.Homework05;

public class Employee { // 父类
    // 属性
    private String name; // 姓名
    private double salary; // 基本工资
    private int salMonth = 12; // 带薪月份 （可能 12 薪，可能 15 薪）

    // 构造器，不带 satMonth
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // 全参构造器
    public Employee(String name, double salary, int salMonth) {
        this.name = name;
        this.salary = salary;
        this.salMonth = salMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    // 打印工资
    public void printSal() {
        System.out.println(this.getName() + "年工资是" + this.getSalary() * this.getSalMonth());
    }

}
