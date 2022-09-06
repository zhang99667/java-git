package com.pkg;

import com.modifier.A;

public class Test {
    //    测试不同包下 modifier 的影响
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.n1);
//      只能访问到 n1 因为 n1 为 public
//      n2 为 protected
//      n3 为 默认
//      n4 为 private
//      除了 public 以外的修饰符不同包下不能


//        不同包下只能访问 public 修饰的方法
        a.m1();
    }
}
