package com.extension.exercise;

public class ExtendsExercise02 {
    public static void main(String[] args) {
        C02 c02 = new C02();
    }
}

class A02 { // A类
    public A02() {
        System.out.println("我是A类");
    }
}

class B02 extends A02 { // B类，继承A类
    public B02() {
        System.out.println("我是B类的无参构造");
    }

    public B02(String name) {
        System.out.println(name + "我是B类的有参构造");
    }
}

class C02 extends B02 {// C类，继承B类

    public C02() {
        this("hello");
        System.out.println("我是c类的无参构造");
    }

    public C02(String name) {
        super("hahah");
        System.out.println("我是c类的有参构造");
    }
}



