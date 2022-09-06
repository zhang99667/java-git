package com.object_;

// 判断两个Person对象的内容是否相等
// 如果两个Person对象的各个属性值都一样，则返回true，反之false

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person person1 = new Person("jack", 10, '男');
        Person person2 = new Person("jack", 10, '男');
        // 没重写 equal 方法的时候 返回 false。
        // 因为 Person 子类继承 Object 父类
        // Object 类的 equal 方法是判断 对象是否相同
        System.out.println(person1.equals(person2));


    }
}

class Person { // extends Object
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // 重写Object的 equal 方法
    @Override
    public boolean equals(Object obj) {
        // 如果比较的两个对象时同一个对象，则直接返回 true
        if (this == obj) return true;
        // 类型判断
        if (obj instanceof Person) // 类型是 Person 才开始比较
        {
            // 类型转换，向下转型。因为需要的到obj的各个属性
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }
        // 如果不是 Person 类型，直接返回 false
        return false;
    }
}
