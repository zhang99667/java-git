package com.extension;

public class Sub extends Base {
    public Sub() { // 无参构造器
        super("smith", 10);// 默认调用父类无参构造器，父类无默认构造器，需要指定一个构造器
        System.out.println("子类 Sub() 无参构造器被调用....");
    }

    public Sub(String name) { // 有参构造器1
        super("smith", 10);// 默认调用父类无参构造器，父类无默认构造器，需要指定一个构造器
        System.out.println("子类 Sub(String name) 构造器被调用....");
    }

    public Sub(String name, int age) {// 有参构造器2
        // 1. 调用父类的无参构造器，或者默认什么都不写。默认调用super()
        // super(); // 父类的默认无参构造器
        // 2. 要调用父类的 Base(String name)构造器
        // super("jack");
        // 3. 要调用父类的 Base(String name,int age)构造器
        super("king", 20);
        System.out.println("子类 Sub(String name,int age) 构造器被调用....");
// `super()` 和  `this()` 都只能放在构造器第一行，因此这两个方法不能共存在一个构造器
//         super 在使用时，必须放在构造器第一行
    }

    public void sayOk() {// 子类方法
        // 非私有的属性和方法可以在子类直接访问
        System.out.println(n1 + " " + n2 + " " + n3); // n4 访问不到，因为是private修饰

        // 如果访问 n4 只能通过父类提供的公共方法去访问
        System.out.println(getN4());

        test100();
        test200();
        test300();
        // 访问不到 test400()，因为 test400() 是 private
        // 只能通过父类提供的公共方法去访问
    }

}
