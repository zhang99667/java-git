
// 6.假定 Grand、Father 和 Son 在同一个包，问：父类和子类中通过 this 和 super 都可以调用哪些属性和方法

package com.Homework;

public class Homework06 {
}

class Grand { // 超类
    String name = "AA";
    private int age = 100;

    public void g1() {
    }
}

class Father extends Grand { // 父类
    String id = "001";
    private double score;

    public void f1() {
        // super 可以访问哪些成损（属性和方法）？
        // this可以访问哪些成员？

        // super 可以访问 父类 name 和 g1()
        // this 可以访问 id score f1() 还有父类中的 this.name this.g1()都是默认修饰符
    }
}

class Son extends Father { // 子类
    String name = "BB";

    public void g1() {
    }

    private void show() {
        // super可以访问哪些成员（属性和方法）？
        // this可以访问哪些成员？

        // super.id
        // super.name
        // super.f1();
        // this.name
        // this.f1();
        // this.g1();


    }
}