// 4.通过继承实现员工工资核算打印功能
// 父类：员工类
// 子类：部门经理 类、普通员工类
// (1)部门经理工资 = 1000 + 单日工资 * 天数 * 等级(1.2)
// (2)普通员工工资 = 单日工资 * 天数 * 等级(1.0)
// (3)员工属性：姓名，单日工资，工作天数
// (4)员工方法（打印工资）
// (5)普遍员工及部门经理都是员工子类，需要重写打印工资方法
// (5)定义并初始化普通员工对象，调用打印工资方法输入工资，定义并初始化部门经理对象，调用打印工资方法输入工资

package com.Homework;

public class Homework04 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager("jack", 400, 300, 1.2, 1000),
                new Staff("smith", 300, 300, 1.0)
        };

        for (Employee employee : employees) {
            employee.printSalary();
        }
    }
}


// 员工类
class Employee {
    private String Name;// 姓名
    private double daySal; // 工资
    private int workDays; // 工作天数
    private double Grade; // 等级

    // 构造方法
    public Employee(String Name, double daySal, int workDays, double Grade) {
        this.setName(Name);
        this.setSalary(daySal);
        this.setDays(workDays);
        this.setGrade(Grade);
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getSalary() {
        return daySal;
    }

    public void setSalary(double daySal) {
        this.daySal = daySal;
    }

    public int getDays() {
        return workDays;
    }

    public void setDays(int workDays) {
        this.workDays = workDays;
    }

    public double getGrade() {
        return Grade;
    }

    public void setGrade(double grade) {
        this.Grade = grade;
    }

    // 方法：打印工资
    public void printSalary() {
        System.out.println("Employee：" + this.getName() + "\t工资 = " + this.getDays() + this.getSalary() * this.getGrade());
    }
}


// 普通员工类
class Staff extends Employee {
    // 构造方法
    public Staff(String Name, double daySal, int workDays, double Grade) {
        super(Name, daySal, workDays, Grade);
    }

    @Override
    public void printSalary() {
        System.out.println("Staff：" + this.getName() + "\t工资 = " + this.getDays() * this.getSalary() * this.getGrade());

    }
}

// 部门经理 类
class Manager extends Employee {
    private double Bonus;

    // 构造方法
    public Manager(String Name, double daySal, int workDays, double Grade, double Bonus) {
        super(Name, daySal, workDays, Grade);
        this.setBonus(Bonus);
    }

    public double getBonus() {
        return Bonus;
    }

    public void setBonus(double bonus) {
        Bonus = bonus;
    }

    @Override
    public void printSalary() {
        System.out.println("Manager：" + this.getName() + "\t工资 = " +
                (this.getBonus() + this.getDays() * this.getSalary() * this.getGrade()));
    }
}