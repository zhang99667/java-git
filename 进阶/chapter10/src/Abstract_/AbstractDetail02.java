package Abstract_;

public class AbstractDetail02 {
    public static void main(String[] args) {

    }
}

// 抽象类的本质还是类，所以可以有类的各种成员
abstract class D{
    public int n1=10;
    public static String name="我爱你";
    public void hi(){
        System.out.println("hi");
    }
    public abstract void hello();
}

// 如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为 abstract 类。
abstract class E extends D{
    public abstract void hi();
}

abstract class F extends E{
    @Override
    public void hi() {
        // 相当于实现父类的 F 的抽象方法。所谓实现方法，就是有方法体
    }
}

abstract class H{
    // 不能用 private final static 修饰
    // private abstract void hi();
}