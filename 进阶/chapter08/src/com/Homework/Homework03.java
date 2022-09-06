// 3.编写老师类 Homework03.java
// (1)要求有属性“姓名name”,“年龄age”,“职称post”,“基本工资salary
// (2)编写业务方法，introduce（)，实现输出一个教师的信息。
// (3)编写教师类的三个子类：教授类(Professor)、副教授类、讲师类。
//     工资级别分别为：教授为1.3、副教授为1.2、讲师类1.1。
//     在三个子类里面都重写父类的introduce()方法。
// (4)定义并初始化一个老师对像，调用业务方法，实现对像基本信息的后台打印.

package com.Homework;

public class Homework03 {
    public static void main(String[] args) {
        Teacher[] teachers = {
                new Professor("jack", 38, "教授", 15000),
                new AssociateProfessor("smith", 48, "副教授", 15000),
                new Lecturer("mark", 28, "讲师", 15000)
        };

        // 输出
        for (Teacher teacher : teachers) {
            System.out.println(teacher.introduce());
        }
    }
}

class Teacher {
    private String name;// 姓名
    private int age;// 年龄
    private String post; // 职位
    private double salary;// 工资

    // 构造方法
    public Teacher(String name, int age, String post, double salary) {
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
        this.setPost(post);
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String introduce() {
        return this.getName() + "\t" + this.getAge() + "\t" + this.getPost() + "\t" + this.getSalary();
    }
}


class Professor extends Teacher {
    // 构造方法
    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, (salary * 1.3)); // 工资等级 1.3 倍
    }

    @Override
    public String introduce() {
        return this.getName() + "\t" + this.getAge() + "\t" + this.getPost() + "\t" + this.getSalary();
    }
}

class AssociateProfessor extends Teacher {
    // 构造方法
    public AssociateProfessor(String name, int age, String post, double salary) {
        super(name, age, post, (salary * 1.2)); // 工资等级 1.2 倍
    }

    @Override
    public String introduce() {
        return this.getName() + "\t" + this.getAge() + "\t" + this.getPost() + "\t" + this.getSalary();
    }
}

class Lecturer extends Teacher {
    // 构造方法
    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, (salary * 1.1)); // 工资等级 1.1 倍
    }

    @Override
    public String introduce() {
        return this.getName() + "\t" + this.getAge() + "\t" + this.getPost() + "\t" + this.getSalary();
    }
}