package com.modifier;

public class B {
    public void say() {
        A a = new A();
//        在同一个包下，可以访问 public、protected、和默认，不能访问private
        System.out.println("n1=" + a.n1 + "  n2=" + a.n2 + "  n3=" + a.n3);
//        访问不到 a4 因为 a4 是 private


//        同包下可以访问 protected 修饰符和 默认 修饰符
        a.m3(); // 默认修饰符
        a.m2(); // protected
        a.m1(); // public
    }

}
