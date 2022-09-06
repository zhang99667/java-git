package CodeBlock_;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        // 类被加载的情况

        // 1. 创建对象实例时（new）
        // AA aa = new AA();

        // 2. 创建子类对象实例，父类也会被加载
        // AA aa2 = new AA();


        // 3. 使用类的静态成员时（静态属性，静态方法）
        // System.out.println(Cat.n1);

        // 4. 被创建一次，就会调用一次
        DD dd = new DD();
        DD dd1 = new DD();
    }
}

class DD {
    public static int n2 = 8888;

    // 调用静态变量，静态代码块一定会被执行
    static {
        System.out.println("DD 的静态代码块 1 被执行");
    }

    // 创建一次，就会调用一次，和是否被创建过无关
    {
        System.out.println("DD 的普通块 1 被执行");
    }
}

class Animal {
    // 静态属性
    static {
        System.out.println("Animal 的静态代码块 1 被执行");
    }
}

class Cat extends Animal {
    public static int n1 = 999;

    // 静态属性
    static {
        System.out.println("Cat 的静态代码块 1 被执行");
    }
}

class BB {
    // 静态代码块
    static {
        System.out.println("BB 的静态代码块 1 被执行");
    }
}


class AA extends BB {

    // 静态代码块
    static {
        System.out.println("AA 的静态代码块 1 被执行...");
    }
}