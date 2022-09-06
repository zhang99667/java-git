package com.Homework.Homework13;

// 父类
public class Person {
    private String name;
    private char gender;
    private int age;

    // 构造方法

    public Person(String name, char gender, int age) {
        this.setName(name);
        this.setGender(gender);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 共有方法
    public String play() {
        return this.getName() + "爱玩";
    }

    public void printInfo(){
        System.out.println("姓名："+this.getName());
        System.out.println("年龄："+this.getAge());
        System.out.println("性别："+this.getGender());
    }
}
