package Static_;

public class StaticMethodDetail {
    public static void main(String[] args) {

        D.hi(); // ok

        // 非静态方法，不能通过类名调用
        // D.say();  // 错误，需要先创建对象
        new D().say();
    }
}

class D {
    private int n1 = 100;
    private static int n2 = 100;

    public void say() {
    } // 非静态方法，普通方法

    public static void hi() {
        // 类方法中不允许使用和对象有关的关键字
        // 比如 this 和 super 普通方法（成员方法）可以
        // this.n1; // 'Static_.D.this' cannot be referenced from a static context

    }  // 静态方法

    // 类方法（静态方法）中只能访问静态变量或静态方法
    public static void hello() {
        System.out.println(n2); // ok
        System.out.println(D.n2); // ok
        // System.out.println(this.n2); // 不可以
        hi(); // ok
        // say();  类方法不能使用非静态方法
    }

    // 小结：静态方法 只能访问静态的成员，非静态的方法 可以访问静态成员和非静态成员(必须遵守访问权限)
    public void ok() {
        // 都ok
        System.out.println(n1);
        System.out.println(n2);
        hello();
        hi();
        say();
    }


}