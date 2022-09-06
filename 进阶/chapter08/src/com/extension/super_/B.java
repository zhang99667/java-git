package com.extension.super_;

public class B extends A {

    public void hi() {
        System.out.println(" " + super.n1 + " " + super.n2 + " " + super.n3); // n4是private不能访问

    }

    public void ok() {
        super.test300();
        super.test100();
        super.test200(); // test400()是 private不能访问
    }

    public void sum() {
        System.out.println("B类的sum()");
        // 希望调用父类A的cal方法
        // 子类B并无cal方法，可以使用如下三中方法进行访问

        // 找cal()方法的顺序
        // 找cal方法时，先找奔雷，如果有则调用；
        // 如果没有，则找父类。有则访问，知道找到Object类
        // 提示：如果查找方法过程中，找到了但是不能访问，则报错
        // 如果查找方法过程中，没有找到则报错

        // cal();
        // this.cal();  //等价于 cal();
        super.cal(); // 直接在父类中查找 cal
    }

    public void cal(){
        System.out.println("B类的cal()");
    }
    public B() {

    }
}
