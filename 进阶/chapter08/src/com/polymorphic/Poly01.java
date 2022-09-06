package com.polymorphic;

public class Poly01 {
    public static void main(String[] args) {
        Master Tom = new Master("jack");


        // 学习多态前
        Dog dog1= new Dog("大黄");
        Bone bone = new Bone("大棒骨");
        Tom.feed(dog1,bone);

        Cat cat1 = new Cat("Tom");
        Fish fish=new Fish("黄花鱼");
        Tom.feed(cat1,fish);

        Pig pig1 = new Pig("母猪一号");
        Rich rich1 = new Rich("五常大米");
        Tom.feed(pig1,rich1);


    }
}

