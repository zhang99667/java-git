package com.Override_.Exercise.Exercise01;

public class Student extends Person {
    private int id;
    private double score;

    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say() {
        return super.say() + "\tid=" + this.id + "\tscore=" + this.score;
    }
}
