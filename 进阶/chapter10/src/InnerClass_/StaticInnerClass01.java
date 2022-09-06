package InnerClass_;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

        // 外部其他类 使用 静态内部类
        // 方式一
        // 因为静态内部类，是可以通过类名直接访问（前提是满足访问权限 比如：private 就不能访问）
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
        // 方式二
        // 编写一个方法，可以返回静态类
        Outer10.Inner10 inner101 = Outer10.getInner10();
        inner101.say();

        // 方式三

    }
}

class Outer10 { // 外部类
    private int n1 = 10;
    private static String name = "张三";

    private static void cry() {
        System.out.println("cry...");
    }

    // Inner10 就是静态内部类
    // 1.放在外部类的成员位置
    // 2.使用 static 修饰
    // 3.可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
    // 4.可以添加任意访问修饰符(public、protected、默认、private),因为它的地位就是一个成员
    public static class Inner10 {
        private static String name = "hspedu";
        public void say() {
            System.out.println(name);
            System.out.println(Outer10.name);
            cry();
        }
    }

    public void m1() {
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public static Inner10 getInner10() {
        return new Inner10();
    }
}