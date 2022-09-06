package com.polymorphic.Exercise;

public class PolyExercise02 {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count); // 20
        s.display(); // 20
        Base b = s; // 向下转型 Sub -> Base
        System.out.println(b == s); // true
        System.out.println(b.count); // 10 -> 属性调用 -> 看编译类型（Base）
        b.display(); // 方法调用 -> 看 b 的运行类型（Sub）
    }
}

class Base {// 父类
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {// 子类
    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }
}