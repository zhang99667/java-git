package com.polymorphic.Detail;


public class Cat extends Animal {
    // 方法重写
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    // Cat特有的方法
    public void catchMouse() {
        System.out.println("抓老鼠！");
    }

}
