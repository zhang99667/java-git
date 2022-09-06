package chapter07;

public class VarScopeDetail {
    public static void main(String[] args) {
        varPerson vp = new varPerson();
        vp.say();
        vp.hi();

        varPerson2 vp2 = new varPerson2();
        vp2.test(); // 第一种跨类访问对象属性的方法 —— 直接访问
        vp2.test2(vp); // 第二种跨类访问对象属性的方法 —— 传类
    }
}

class varPerson {

    private int age = 20; // 全局变量/属性可以加修饰符

    String name = "jack";

    public void say() {
        // public age =10; // 局部变量不可以加修饰符
        String name = "king"; // 就近原则
        System.out.println("say() name = " + name);
        System.out.println("say() age = " + age);
    }

    public void hi() {
        String address = "BeiJing";
        // String address = "Shagnhai"; // 不能重复定义变量
        System.out.println("hi() address=" + address);
    }
}

class varPerson2 {
    public void test() {
        // 可以被本类使用，或其他类使用( 通过对象调用)
        varPerson vp = new varPerson();
        System.out.println("可以调用 varPerson的全部变量 name = " + vp.name); // 调用不同类中的全局变量
    }

    public void test2(varPerson p) {
        System.out.println(p.name);
    }
}