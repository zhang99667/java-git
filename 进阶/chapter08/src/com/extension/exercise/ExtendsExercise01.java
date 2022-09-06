package com.extension.exercise;

import com.modifier.B;

public class ExtendsExercise01 {
    public static void main(String[] args) {
        B01 b = new B01();

    }
}

class A01 {
    A01() {
        System.out.println("a");
    }

    A01(String name) {
        System.out.println("a name");
    }
}

class B01 extends A01 {
    B01() {
        this("abc");
        System.out.println("b");
    }

    B01(String name) {
        // super();
        System.out.println("b name");
    }
}
