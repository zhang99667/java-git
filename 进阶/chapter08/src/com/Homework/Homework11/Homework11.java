// 11.现有Person类，里面有方法run、eat,Student类继承了Person类，并重写了run方
// 法，自定义了 study 方法，试写出对象向上转型和向下转型的代码，并写出各自都可以调用
// 哪些方法，并写出方法输出什么？

package com.Homework.Homework11;

public class Homework11 {
    public static void main(String[] args) {
        Person stu_jack = new Student("jack", 18, 1); // 向上转型
        Person stu_tom = new Student("tom", 18, 2); // 向上转型

        stu_tom.eat(); // person eat
        stu_tom.run(); // student run
        stu_jack.eat(); // person eat
        stu_jack.run(); // student run


        Student stu1 = (Student) stu_jack; // 向下转型
        stu1.eat(); // person eat
        stu1.run(); // student run
        stu1.study(); // student study

    }
}

