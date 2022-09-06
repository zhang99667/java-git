package chapter07.Homework;

public class Homework10 {
    public static void main(String[] args) {

    }
}

// 创建一个Employee类
// 属性有（名字，性别，年龄，职位，薪水），提供3个构造方法，可以初始化
// (1) (名字，性别，年龄，职位，薪水)
// (2) (名字，性别，年龄)
// (3)（职位，薪水），要求充分复用构造器
class Employee {
    String name;
    char gender;
    int age;
    String job;
    double sal;

    public Employee(String name, char gender, int age, String job, double sal) {
        this(name, gender, age);
        this.job = job;
        this.sal = sal;
    }

    public Employee(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String job, double sal) {
        this.job = job;
        this.sal = sal;
    }
}