package Single_;

/*
 * 演示 懒汉式的单例模式
 * */
public class SingleTon02 {
    public static void main(String[] args) {

        Cat cat = Cat.getInstance();
        System.out.println(cat);

        // 再次调用 getInstance
        Cat cat1 = Cat.getInstance();
        System.out.println(cat1);

        System.out.println("是否同对象：" + (cat == cat1));
    }
}

// 希望在程序运行过程中，只能创建一个 Cat 对象
// 使用单例模式
class Cat {
    private String name;

    // 步骤：
    // 1. 私有化构造器
    // 2. 定义一个 static 静态属性对象
    // 3. 提供一个 public 的 static 方法，可以返回一个 Cat 对象
    // 4. 懒汉式，只有当用户使用getInstance时，才返回 Cat 对象，再次调用时，会反悔上次创建的 Cat
    //      从而保证了单例
    private static Cat cat;
    public static Cat getInstance() {
        if (cat == null) // 如果没有创建 Cat 对象
            cat = new Cat("多啦");
        return cat;
    }
    private Cat(String name) {
        System.out.println("构造器已调用");
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}