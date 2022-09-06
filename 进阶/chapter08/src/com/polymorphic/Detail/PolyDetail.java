package com.polymorphic.Detail;

public class PolyDetail {
    public static void main(String[] args) {
        // 向上转型：父类的引用指向子类的对象
        // 语法：父类类型 引用名 = new 子类类型();
        Animal animal = new Cat();

        // Object obj = new Cat(); // 可以，因为 Object 也是 Cat 的父类（祖宗类）
        animal.eat();  // 猫吃鱼
        // --> 调用方法是按照从运行类型（子类）开始查找
        // 然后调用，规则和方法调用规则一致
        animal.run();
        animal.show();
        animal.sleep();
        // 不能调用子类特有的方法，只能调用子类重写的方法
        // 因为在编译阶段，能调用那些成员，是由编译类型来决定的
        // animal.catchMouse(); 错误

        // 向下转型：
        // 父类类型 引用名 = new 子类类型();
        Cat cat = (Cat) animal;
        cat.catchMouse();

        // 要求父类的引用必须指向的是当前目标类型的对象
        // Dog dog = (Dog) animal; // 可以吗？不可以  cat -> dog （上面已经将animal转化为Cat）
        // 上面的运行起来会抛异常，Exception in thread "main" java.lang.ClassCastException:
    }
}
