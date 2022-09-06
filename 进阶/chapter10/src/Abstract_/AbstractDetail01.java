package Abstract_;

public class AbstractDetail01 {
    // 抽象类，不能被实例化
    // new A();
}

// 抽象类不一定要包含 abstract 方法，也就是说，抽象类可以没有 abstract 方法
abstract class A {
    public void hi() {
        System.out.println("hi");
    }
}

// 一旦类包含了 abstract 方法，则这个类必须声明为 abstract
abstract class B{
    public abstract void hi();
    // abstract 只能修饰 类 和 方法，不能修饰属性和其他
    // public abstract int num=10;
}