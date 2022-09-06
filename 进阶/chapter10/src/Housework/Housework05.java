package Housework;

/*
 *
 * 1.编一个类A,在类中定义 局部内部类 B, B 中有一个私有 final 常量 name, 有一个方法 show() 打印常量 name。进行测试
 * 2.进阶：A中也定义一个私有的变量 name,在 show 方法中打印测试
 *  */
public class Housework05 {
    public static void main(String[] args) {
        new A().f1();
    }
}

// 外部类
class A {
    private String name = "Outer class name trump";

    public void f1() {
        // 局部内部类
        class B {
            private String name = "Inner class name jack";

            public void show() {
                System.out.println("Inner class B: " + name);
                System.out.println("Outer class A: " + A.this.name);
            }
        }

        new B().show();
    }
}