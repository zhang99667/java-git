package chapter07;

public class VarScope01 {
    public static void main(String[] args) {

    }
}

class varCat {
    /*
     * 1. 局部变量一般是指在成员方法中定义的变量
     * 2. n 和 name 就是局部变量
     * 3. n 和 name 的作用域在 cry 方法中
     */
    int age = 10;

    public void cry() {
        int age = 10;
        String name = "jack";
        System.out.println("在cry中使用属性 age =" + age);
        System.out.println("在cry中使用属性 name =" + name);
    }

    public void eat() {
        System.out.println("在eat中使用属性 age=" + age);
    }
}
