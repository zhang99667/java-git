package Enum_;

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season02.AUTUMN);
    }
}

// 演示使用 enum 定义枚举实例
// 1. 使用 enum 关键字替代 class
enum Season02 { // 类

    // 如果使用 enum 来实现枚举类
    // 2. public static final 用一下代替 常量名(实参列表)
    // 3. 如果有多个常量对象，使用 , 号间隔。
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷"),
    nonePram; // 如果使用无参构造器创建常量对象，则可以省略(参数)


    // 枚举对象，必须放在类的行首。(属性要放在常量后面)
    private String name;
    private String desc; // 描述.

    Season02(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private Season02() { // 无参构造器
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