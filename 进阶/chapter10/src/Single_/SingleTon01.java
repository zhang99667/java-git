package Single_;

public class SingleTon01 {
    public static void main(String[] args) {
        // GirlFriend jr = new GirlFriend("慢慢");
        // GirlFriend ly = new GirlFriend("小羊");

        GirlFriend jr = GirlFriend.getInstance();
        System.out.println(jr);

        GirlFriend jr1 = GirlFriend.getInstance();
        System.out.println(jr);

        System.out.println(jr1 == jr);

    }
}

// 有一个类， GirlFriend
// 只能有一个女朋友
class GirlFriend {
    // 如何保障我们只能创建一个 GirlFriend 对象
    // 步骤【单例模式 - 饿汉式】：
    private String name;

    // 1. 将构造器私有化
    private GirlFriend(String name) {
        this.name = name;
    }

    // 2. 在类的内部直接创建
    // 为了能够在静态方法中，返回gf对象，需要将其修饰为static
    private static GirlFriend jr = new GirlFriend("慢慢");

    // 3. 向外部暴露一个公共的 static 方法，返回 gf 对象
    public static GirlFriend getInstance() {
        return jr;
    }

    @Override
    public String toString() {
        return this.name;
    }
}