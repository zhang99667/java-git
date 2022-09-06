package com.Homework.Homework05;

public class Peasant extends Employee {
    public Peasant(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        System.out.print("农民：");
        super.printSal();
    }
}
