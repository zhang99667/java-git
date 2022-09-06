package chapter07;

public class ConstructorDetail {
    public static void main(String[] args) {

        // p1.conPerson01(); // 不能主动调用构造器

        conPerson01 p1 = new conPerson01("jack");
        conPerson01 p2 = new conPerson01("tom", 15);
        System.out.println("p1的信息：" + p1.name + " & " + p1.age);
        System.out.println("p2的信息：" + p2.name + " & " + p2.age);

        conDog dog1 = new conDog(); // 使用默认的无参
        System.out.println(dog1);
    }
}

class conPerson01 {
    String name;
    int age;

    // 第一个构造器
    public conPerson01(String pName, int pAge) {
        name = pName;
        age = pAge;
    }

    // 第二个构造器，只指定人名，不指年龄
    public conPerson01(String pName) {
        name = pName;
    }

}

class conDog {
    // 如果程序员没有定义构造器，系统会自动给类生成一个默认无参构造器（也叫默认构造器）
    // 使用javap指令 反编译看看

    /*
     * 默认构造器
     * Dog() {
     * }
     */

    // 一旦定义了自己的构造器，默认的构造器就覆盖了，就不能再使用默认的无参构造器，除非显式的定义一下，
    public conDog() {

    }

}

