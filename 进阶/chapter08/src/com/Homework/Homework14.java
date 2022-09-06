// 14.程序阅读题在 main 方法中执行：C c=new C;
// 输出什么内容？

package com.Homework;

public class Homework14 {
    public static void main(String[] args) {
        C c = new C();
    }
}

class A {// 超类

    public A() {
        System.out.println("我是A类");
    }
}

class B extends A {// 父类

    public B() {
        System.out.println("我是B类的无参构造");
    }

    public B(String name) {
        System.out.println(name + "我是B类的有参构造");
    }
}

class C extends B {// 子类

    public C() {
        this("hello");
        System.out.println("我是c类的无参构造");
    }

    public C(String name) {
        super("ha haha");
        System.out.println("我是c类的有参参构造");
    }
}

// 我是A类
// ha haha我是B类的有参构造
// 我是c类的有参参构造
// 我是c类的无参构造