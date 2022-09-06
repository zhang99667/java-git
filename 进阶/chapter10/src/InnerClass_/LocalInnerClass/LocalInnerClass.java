package InnerClass_.LocalInnerClass;

// 演示局部内部类的使用
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}

class Outer02 { // 外部类
    private int n1 = 100; // 私有属性

    private void m2() { // 私有方法
        System.out.println("Outer02 m2()");
    }

    public void m1() { // 方法
        // 1. 局部内部类 是定义在 外部类 的 局部位置，通常在方法
        // 3. 不能添加访问修饰符，但是可以使用 final 修饰，加 final 不能被继承
        // 4. 作用域：仅仅在定义它的方法或代码块中
        class Inner02 { // 局部内部类（本质仍然一个类）
            // 2. 可以直接访问外部类的所有成员，包含私有的
            private int n1 = 800;

            public void f1() {
                // 5. 局部内部类可以直接访问外部类的成员
                // 7. 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问 外部类 的成员，使用 外部类名.this.成员 去访问
                // 谁调用， 外部类.this 就是哪个对象。
                System.out.println("n1 = " + n1 + "\t外部内部类的n1 = " + Outer02.this.n1); // 局部内部类 访问 私有属性
                m2(); // 局部内部类 访问 私有方法
            }
        }
        // 6. 外部类在方法中，可以创建 Inner02 对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();

        class Inner03 extends Inner02 {
        }
    }
}