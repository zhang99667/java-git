package com.polymorphic.PolyArr;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String say() {
        return "student:\t" + super.say() + "\tscore=" + this.score;
    }


    // 特有方法
    public void study(){
        System.out.println("studying...");
    }
}
