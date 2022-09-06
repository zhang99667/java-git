package com.extension;

public class ExtendsDetail {
    public static void main(String[] args) {
        System.out.println("======第一个对象======");
        Sub sub = new Sub();
        // sub.sayOk();

        System.out.println("======第二个对象======");
        Sub sub2 = new Sub("jack",20);


    }
}
