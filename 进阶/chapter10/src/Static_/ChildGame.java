package Static_;

public class ChildGame {
    public static void main(String[] args) {

        Child child1 = new Child("白骨精");
        child1.join();
        child1.count++;

        Child child2 = new Child("狐狸精");
        child1.join();
        child2.count++;

        Child child3 = new Child("老鼠精");
        child1.join();
        child3.count++;

        // 类变量可以通过类来访问
        System.out.println("共有" + Child.count + "小孩加入了游戏...");


    }
}

class Child {
    private String name;
    // 定义一个变量 count ，是一个类变量（静态变量 -> 使用 static 修饰）
    // 该变量最大的特点就是被 Child类 所有的对象实例共享
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }


    public void join() {
        System.out.println(name + "加入了游戏...");
    }
}