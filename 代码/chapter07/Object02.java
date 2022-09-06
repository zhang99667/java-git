package chapter07;

public class Object02 {
    public static void main(String[] args) {
        Cat02 cat = new Cat02();
        System.out.println("String 默认值：" + cat.color);
        System.out.println("double 默认值：" + cat.price);
    }

}

class Cat02 {
    // 属性
    String name; // 名字
    double price; // 体重
    String color; // 颜色
    String[] master; // 属性可以是基本的数据类型，也可以是引用类型（对象，数组）
}