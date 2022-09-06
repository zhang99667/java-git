package com.extension;

import com.modifier.A;

public class Base extends TopBase {
    // 4 个属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base() { // 无参构造器
        // 子类必须调用父类的构造器，完成父类的初始化
        System.out.println("父类base() 无参构造器被调用....");
    }

    public Base(String name, int age) { // 有参构造器1
        System.out.println("父类Base(String name,int age) 构造器被调用....");
    }

    public Base(String name) {
        System.out.println("父类Base(String name) 构造器被调用....");
    }

    public void test100() {
        System.out.println("test100");
    }

    protected void test200() {
        System.out.println("test200");
    }

    void test300() {
        System.out.println("test300");
    }

    public int getN4() {
        return n4;
    }

    private void test400() {
        System.out.println("test400()");
    }

    // call
    public void callTest400() {
        test400();
    }
}
