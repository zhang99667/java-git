package chapter07;

public class ThisDetai {
    public static void main(String[] args) {
        thisT t1 = new thisT();
        t1.f2();
        System.out.println("t1 => "+"name = " + t1.name + "   age = " + t1.age);

        thisT t2 = new thisT("jack", 18);
        t2.f3();
    }
}

class thisT {
    String name;
    int age;
    // 细节：访问构造器语法：this(参数列表);
    // 注意：只能在构造其中使用（即只能在构造器中访问另一个构造器）

    // 构造器1
    public thisT() {
        this("tom&jarry", 8); // 如果 要在一个构造器中访问另一个构造器，必须放在第一条

        System.out.println("T() 构造器");
        // 这里去访问thisT(String name, int age)
    }

    // 构造器2
    public thisT(String name, int age) {
        System.out.println("thisT(String name,int age) 构造器");
        this.name = name;
        this.age = age;
    }

    // 方法：
    public void f1() {
        System.out.println("f1() 方法...");
    }

    public void f2() {
        System.out.println("f2() 方法...");
        // 调用本类的 f1
        // 第一种方式
        f1();
        // 第二种方式
        this.f1();
    }

    public void f3() {
        String name = "smith";
        // 传统方式
        System.out.println("name = " + name);
        // 也可以使用this访问属性
        System.out.println("name = " + this.name);
    }
}