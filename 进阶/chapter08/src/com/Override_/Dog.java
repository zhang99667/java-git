package com.Override_;

public class Dog extends Animal {
    // 1.Dog 是 Animal 的子类
    // 2.Dog 和 cay() 方法的 Animal 的 cry() 定义形式一样（名称、返回类型、参数）
    // 3.这时我们就说 Dog 的 cry() 方法，重写了 Animal 的 cry() 方法

    public void cry() {
        System.out.println("dog叫唤");
    }

    public String m1() {
        return null;
    }

    // 不能这样，因为Object不是String的子类，因此编译器错误。
    /*
        public Object m2(){
            return null;
        }
    */

    // BBB继承AAA是AAA的子类，故可以返回。类似String是Object的子类。
    public BBB m3() {
        return null;
    }
}

