package com.extension;

/*
 * 继承的本质
 *  */

public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();// 执行此句话后的内存分析
        // 要按照查找关系来返回信息
        // （1）首先，看子类是否有该属性
        // （2）如果子类有这个属性，并且可以访问，则返回信息
        // （3）如果子类没有这个属性，就向上查找父类
        // （4）如果父类没有就按照（3）的规则，继续向上查找，知道 Object 类

        System.out.println(son.name); // Son
        System.out.println(son.getAge()); // Father
        System.out.println(son.hobby); // Grandpa
    }
}

class GrandPa {// 爷爷类
    String name = "大头爷爷";
    String hobby = "旅游";
}

class Father extends GrandPa { // 父类
    String name = "大头爸爸";
    private int age = 39; // private 修饰的，不能访问。可以通过公有方法访问

    public int getAge() {
        return age;
    }
}

class Son extends Father {// 子类
    String name = "大头儿子";
}