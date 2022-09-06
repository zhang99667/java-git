package CodeBlock_;

public class CodeBlockDetail02 {
    public static void main(String[] args) {
        A a = new A();
        // getN1被调用...
        // A 静态代码块01

        System.out.println("===========");
        B b = new B();
        // B 静态代码块01
        // getN2被调用...
        // B 普通代码块01
    }
}

class A {
    // static 类变量，在类加载的时候就生成了
    private static int n1 = getN1();

    // `static` 代码块是类加载时，执行，只会执行一次。
    static {
        System.out.println("A 静态代码块01");
    }

    public static int getN1() {
        System.out.println("getN1被调用...");
        return 100;
    }
}


class B {
    // 普通属性的初始哈
    private int n2 = getN2();

    // 普通代码块
    {
        System.out.println("B 普通代码块01");
    }

    // 静态代码快
    static {
        System.out.println("B 静态代码块01");
    }

    public static int getN2() {
        System.out.println("getN2被调用...");
        return 100;
    }

    // 无参构造器
    public B() {
        System.out.println("B 构造器被调用！");
    }
}
