package com.polymorphic.Detail;

public class PolyDetail02 {
    public static void main(String[] args) {
        // 属性没有重写之说，属性的值看编译类型
        Base base = new Sub(); // 向上转型
        System.out.println(base.count);

        Sub sub = new Sub();
        System.out.println(sub.count);
    }
}

class Base {// 父类
    int count = 10;// 属性
}

class Sub extends Base {// 子类
    int count = 20;// 属性
}