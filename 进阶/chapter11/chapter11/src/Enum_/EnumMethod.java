package Enum_;

public class EnumMethod {
    public static void main(String[] args) {
        // 使用 Season03 枚举类，来演示各种方法

        // 输入枚举对象
        System.out.println("Season03.AUTUMN: " + Season03.AUTUMN);

        // ordinal() 输入的是该枚举对象的 次序/编号，从0开始编号
        // Season03.AUTUMN 是第三个，因此输出2
        System.out.println("ordinal: " + Season03.AUTUMN.ordinal());

        // 从反编译可以看到 values 方法，返回 Season03[]
        // 该方法含有定义的所有枚举对象
        System.out.println("values: " + Season03.values());
        for (Season03 season : Season03.values()) {
            System.out.println("\t\t" + season);
        }

        // valueOf 执行流程：
        // 1. 根据你输入的 name 去到 Season03 的枚举对象中查找
        // 2. 如果找到了，就返回；如果没有找到，就报错
        System.out.println("valueOf: " + Season03.valueOf("AUTUMN"));

        // compareTo:比较两个枚举常量，比较的就是编号
        // 1. 就是把 Season03.AUTUMN 的编号 和 Season03.SUMMER 的编号比较
        // 2 - 1 = 1
        System.out.println("compareTo: " + Season03.AUTUMN.compareTo(Season03.SUMMER));
    }
}

enum Season03 { // 类

    // 如果使用 enum 来实现枚举类
    // 2. public static final 用一下代替 常量名(实参列表)
    // 3. 如果有多个常量对象，使用 , 号间隔。
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");

    // 枚举对象，必须放在类的行首。(属性要放在常量后面)
    private String name;
    private String desc; // 描述.

    Season03(String name, String desc) {
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
}