package Enum_;

public class Enumeration01 {
    public static void main(String[] args) {
        // 使用
        System.out.println(Season.SPRING);
        // 按照老师设计类的思路，不能体现季节是固定的四个对象
        // 因此这样的设计不好 ==> 枚举类型【枚：一个一个 举：例举，即把具体的对象一个一个例举出来的类
        // 这样的类成为枚举类】
        // Season sunshine = new Season("白天", "有太阳");
    }
}

// 演示定义枚举实例
class Season { // 类
    private String name;
    private String desc; // 描述.

    // 定义了四个固定的对象
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");

    // 1. 将构造器私有化，目的防止 直接 new
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    // 2. 只保留 get 方法，目的防止属性被修改
    // 3. 在 Season 内部，直接创建固定的对象
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + this.getName() + '\'' +
                ", desc='" + this.getDesc() + '\'' +
                '}';
    }
}