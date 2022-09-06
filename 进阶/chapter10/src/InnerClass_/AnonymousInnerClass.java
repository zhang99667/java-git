package InnerClass_;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.method();
    }
}

class Outer01 { // 外部类
    private int n1 = 10; // 私有属性

    public void method() { // 方法
        // 基于接口的匿名内部类
        // 1. 需求：想使用 接口A，并创建对象。
        // 2.传统方式：写一个类实现该接口，并创建对象
        A tiger = new Tiger();
        tiger.cry();
        // 3.需求是 Tiger / Dog 类，只是使用一次，后面便不再使用
        // 4. 可以使用匿名内部类来简化开发
        // 5. dog 的编译类型是什么？ A
        // 6. dog 的运行类型是什么？ 就是匿名内部类 A
        /*
         * 我们看底层：会分配 类名 Outer01$1
         * 类和接口的关系 -> 实现
         * class XXX implements A {
         *   @Override
         *   public void cry() {
         *       System.out.println("老虎叫唤...");
         *   }
         * }
         *  */
        // 7. JDK 底层在创建匿名内部类 Outer01$1，立即马上就创建了 Outer01$1 实例，并且把地址返回给 dog
        // 8. 匿名内部类使用一次，就不能在用了。但是实例可以继续使用
        A dog = new A() {
            @Override
            public void cry() {
                System.out.println("狗叫...");
            }
        };
        dog.cry();
        System.out.println("dog的运行类型：" + dog.getClass());

        // 演示基于类的匿名内部类
        // 1. jack 的编译类型 Father
        // 2. jack 的运行类型 Outer01$2
        // 3. 底层会创建匿名内部类
        /*
         * 类和类之间的关系 -> 继承
         * class Outer01$2 extend Father
         *
         *  */
        // 4. 同时也直接返回了 匿名内部类 Outer04$2 的对象
        // 5. 注意 ("jack") 参数列表会传递给 Father 构造器
        Father jack = new Father("jack") {

        };
        System.out.println("jack 对象的运行类型：" + jack.getClass());

        Father jack1 = new Father("jack");
        System.out.println("jack1 对象的运行类型：" + jack1.getClass());

        // 基于抽象类的匿名内部类
        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("dog eat bones...");
            }
        };
    }

    interface A { // 接口
        public void cry();
    }

    // 传统方式
    class Tiger implements A {
        @Override
        public void cry() {
            System.out.println("老虎叫唤...");
        }
    }

    class Father { // 类
        public Father(String name) { // 构造器
        }
    }
}

abstract class Animal {
    abstract void eat();
}