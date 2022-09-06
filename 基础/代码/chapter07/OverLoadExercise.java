package chapter07;

public class OverLoadExercise {
    public static void main(String[] args) {
        Methods method = new Methods();
        method.m("hello world");
        method.m(2);
        method.m(1, 1);

        System.out.println(method.max(2, 3));
        System.out.println(method.max(1.2, 1.3));
        System.out.println(method.max(1.1, 1.3, 2));
        System.out.println(method.max(1.1, 1.3, 2.3));
    }
}

class Methods {
    /*
     * 编写程序，类Methods中定义三个重载方法并调用。方法名为 m。
     * 三个方法分别接收一个int参数、两个int参数、一个字符串参数。
     * 分别执行平方运算并输出结果 相乘并输出结果，输出字符串信息。
     * 在主类的main（)方法中分别用参数区别调用三个方法
     */
    public void m(int n) {
        System.out.println("平方 = " + (n * n));
    }

    public void m(int n1, int n2) {
        System.out.println("相乘 = " + (n1 * n2));
    }

    public void m(String str) {
        System.out.println("传入的 string = " + str);
    }

    /*
     * 定义三个重载方法max()
     * 第一个方法，返回两个int值中的最大值
     * 第二个方法，返回两个double值中的最大值
     * 第三个方法，返回三个double值中的最大值，并分别调用三个方法
     */

    public int max(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    public double max(double n1, double n2) {
        return n1 > n2 ? n1 : n2;
    }

    public double max(double n1, double n2, double n3) {
        System.out.print("max(double n1, double n2, double n3) = ");
        return (n1 > n2 ? n1 : n2) > n3 ? (n1 > n2 ? n1 : n2) : n3;
    }

    public double max(double n1, double n2, int n3) {
        System.out.print("max(double n1, double n2, int n3) = ");

        return (n1 > n2 ? n1 : n2) > n3 ? (n1 > n2 ? n1 : n2) : n3;
    }
}