package Housework;

/*
 * 1. 动物类 Animal 包含了抽象方法 shout():
 * 2. Cat 类继承了 Animal,并实现方法 shout,打印“猫会喵喵叫”
 * 3. Dog 类继承了 Animal,,并实现方法 shout,打印“狗会汪汪叫”
 * 4. 在测试类中实例化对像Animal cat=new Cat(),并调用 cat 的 shout 方法
 * 5. 在测试类中实例化对像Animal dog=new Dog(),并调用 dog 的 shout 方法
 *  */

import Abstract_.TestTemplate_.A;

public class Housework03 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        cat.shout();
        dog.shout();
    }
}

abstract class Animal {
    abstract void shout();
}

class Cat extends Animal {
    @Override
    void shout() {
        System.out.println("猫会喵喵叫...");
    }
}

class Dog extends Animal {

    @Override
    void shout() {
        System.out.println("狗会汪汪叫...");
    }
}
