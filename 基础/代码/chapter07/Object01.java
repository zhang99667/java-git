package chapter07;

public class Object01 {
    public static void main(String[] args) {
        /*
         * 张老太养了两只猫猫：一只名字叫小白，今年3岁，白色。
         * 还有一只叫小花，今年10岁，花色。
         * 请编写一个程序：
         * 当用户输入小猫的名字时， 就显示该猫的名字，年龄，颜色。
         * 如果用户输入的小猫名错误， 则显示张老太没有这只猫猫。
         */

        // 单独变量来解决 => 不利于数据的管理
        // 第1只猫的信息
        String cat1Name = "小花";
        int cat1Age = 3;
        String cat1Color = "白色";
        System.out.println(cat1Name + cat1Age + cat1Color);
        // 第2只猫的信息
        String cat2Name = "小花";
        int cat2Age = 30;
        String cat2Color = "花色";
        System.out.println(cat2Name + cat2Age + cat2Color);

        // 数组 => (1) 数据类型无法体现
        // 数组 => (2) 只能通过 [下标] 获取信息，造成变量名和内容对应关系不明确
        // 数组 => (3) 无法体现行为
        // 第1只猫的信息
        String[] car1 = { "小白", "3", "白色" };
        System.out.println(car1[0] + car1[1] + car1[2]);
        // 第2只猫的信息
        String[] car2 = { "小花", "30", "花色" };
        System.out.println(car2[0] + car2[1] + car2[2]);

        // 使用O0P面向对象解决
        // 实例化一只猫[创建一只猫对象]
        // 老韩解读
        // 1.new Cat() 创建一只猫
        // 2.Catcat1=new Cat(); 把创建的猫赋给 cat1
        Cat cat1 = new Cat();
        cat1.name = "小白";
        cat1.age = 3;
        cat1.color = "白色";
        cat1.weight = 2.5;
        Cat cat2 = new Cat();
        cat2.name = "小花";
        cat2.age = 30;
        cat2.color = "花色";
        cat2.weight = 2.5;

        // 怎么访问对象的属性呢？
        System.out.println("第一只猫信息：" + cat1.name + " " + cat1Age + " " + cat1Color + " " + cat1.weight);
        System.out.println("第二只猫信息：" + cat2.name + " " + cat2Age + " " + cat2Color + " " + cat2.weight);
    }
}

// 使用面向对象的方式来解决养猫问题
// 定义一个猫类cat->自定义的数据类型
class Cat {
    // 属性
    String name; // 名字
    int age; // 年龄
    String color; // 颜色
    double weight; // 体重
}