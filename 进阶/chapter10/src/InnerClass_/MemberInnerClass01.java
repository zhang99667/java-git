package InnerClass_;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        // 外部其他类， 使用成员内部类的三种方式

        // 第一种方式
        // outer08.new Inner08(); 相当于把 new Inner08() 当做是 outer08 成员
        // 这就是一个语法，不要特别的纠结
        Outer08.Inner08 inner08 = outer08.new Inner08();

        // 第二种方式，在外部类中，编写一个方法，可以放回 Inner08 对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();

        // 第三种方式
        Outer08.Inner08 inner081 = new Outer08().new Inner08();
    }
}

class Outer08 { // 外部类
    private int n1 = 10;
    public String name = "zhangSan";

    // 注意：成员内部类，是定义在外部内的成员位置上
    class Inner08 { // 成员内部类
        public double sal = 999.9;
        private int n1 = 66;

        public void say() {
            // 可以直接访问外部类的所有成员，包含私有的。
            // 如果成员内部类的成员和外部类的成员重名，会遵循就近原则
            System.out.println("n1 = " + n1 + "\tname = " + name);
            System.out.println("外部类n1 = " + Outer08.this.n1);
        }
    }

    // 方法
    public void t1() {
        // 使用了成员内部类
        // 创建成员内部类的对象，然后使用相关的属性或方法
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal); // 外部类 访问 成员内部类
    }

    // 返回一个 Inner08 实例
    public Inner08 getInner08Instance() {
        return new Inner08();
    }
}