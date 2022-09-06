package com.polymorphic.PolyArr;

public class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String say() {
        return "Teacher:\t" + super.say() + "\tsalary=" + this.salary;
    }

    public void teach() {
        System.out.println("teaching...");
    }
}
