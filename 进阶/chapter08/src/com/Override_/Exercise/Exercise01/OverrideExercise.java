package com.Override_.Exercise.Exercise01;

// 编写一个Person类
// 包括属性/privatename.age)构造器、方法say(返回自我介绍的字符串)编写一个Student:类
// 继承Person类，增加id、scorel属性/private,以及构造器，定义sy方法（返回自我介绍的信息）。
// 在main中，分别创建Person和Student对象，调用say方法输出自我介绍。
public class OverrideExercise {
    public static void main(String[] args) {
        Student jack = new Student("jack", 11, 01, 120);
        System.out.println(jack.say());

        Student smith = new Student("smith", 12, 02, 98.8);
        System.out.println(smith.say());
    }
}
