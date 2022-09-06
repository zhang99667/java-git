package com.polymorphic.Dynamic_;

public class DynamicBinding {
    public static void main(String[] args) {
        A a = new B();// 向上转型
        System.out.println(a.sum()); // ?40
        System.out.println(a.sum1()); // ?30
    }
}

class A {// 父类
    public int i = 10;

    // 动态绑定机制

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A { // 子类
    public int i = 20;

    public int sum() {
        return i + 20;
    }

    public int getI() {
        return i;
    }

    public int sum10() {
        return i + 10;
    }
}