package chapter07;

public class OverLoad01 {
    public static void main(String[] args) {
        MyCalculator mc = new MyCalculator();
        System.out.println(mc.calculate(1, 2)); // 两个 int
        System.out.println(mc.calculate(1.1, 2)); // double + int

    }
}

class MyCalculator {

    // 两个 int 的和
    public int calculate(int n1, int n2) {
        return n1 + n2;
    }

    // 一个 int 一个 double 的和
    public double calculate(int n1, double n2) {
        return n1 + n2;
    }

    // 一个 double 一个 int 的和
    public double calculate(double n1, int n2) {
        return n1 + n2;
    }

    // 三个 int 的和
    public int calculate(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
}