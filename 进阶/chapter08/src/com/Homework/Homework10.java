package com.Homework;

import javax.print.Doc;

public class Homework10 {
    public static void main(String[] args) {
        Doctor[] doctors = {
                new Doctor("jack", 50, "牙科医生", '男', 20000),
                new Doctor("rose", 20, "临床护理", '女', 8000),
                new Doctor("jack", 50, "牙科医生", '男', 20000),
        };

        System.out.println(doctors[0].equals(doctors[1]));
        System.out.println(doctors[0].equals(doctors[2]));
    }
}

class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.setName(name);
        this.setAge(age);
        this.setJob(job);
        this.setGender(gender);
        this.setSal(sal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) // 是同一个对象，直接返回 True
            return true;
        if (!(obj instanceof Doctor)) // 不是同一个对象，且不是是 Doctor 的子类，直接返回 false
            return false;
        // 不是同一个对象，但是 Doctor 的子类
        Doctor doc = (Doctor) obj; // 向下转型
        if (this.age == doc.age && this.name.equals(doc.name) && this.sal == doc.sal &&
                this.gender == doc.gender && this.job.equals(doc.job)) return true;
        return false;
    }
}