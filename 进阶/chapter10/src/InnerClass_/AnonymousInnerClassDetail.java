package InnerClass_;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        outer1.f1();
    }
}

class Outer1 {
    private int n1 = 99;

    public void f1() {
        // 创建一个基于类的匿名内部类
        // 不能添加访问修饰符，因为他的地位就是一个局部变量
        // 作用域：仅仅在定义他的方法或代码块中
        Person p = new Person() {
            private int n1 = 88;

            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi() 方法");
                // 默认遵循就近原则，如果想访问外部类的成员，则可以使用（Outer1.this.n1）去访问
                // Outer1.this 指的是外部类的对象，即哪一个对象调用 f1 就是哪一个
                System.out.println("n1 = " + n1);
                System.out.println("n1 = " + Outer1.this.n1);
            }
        };
        p.hi(); // 动态绑定，真正的运行类型是 Outer1$1

        // 也可以直接调用
        new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi方法，哈哈...");
            }
        }.hi();

        new Person() {
            @Override
            public void hi(String str) {
                System.out.println("匿名内部类重写了 hi(String str) 方法" + str);
            }
        }.hi("jack");
    }
}

class Person {
    public void hi() {
        System.out.println("Person hi()");
    }

    public void hi(String str) {
        System.out.println("Person hi()" + str);
    }
}

// 抽象类/接口...