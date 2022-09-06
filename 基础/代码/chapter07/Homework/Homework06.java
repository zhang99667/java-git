package chapter07.Homework;

public class Homework06 {
    public static void main(String[] args) {
        Cale cale = new Cale(1, 2.3);
        System.out.println("加=" + cale.sum());
        System.out.println("减=" + cale.minus());
        System.out.println("乘=" + cale.mul());
        Double divRes = cale.div();
        if (divRes != null) {
            System.out.println("除=" + divRes);
        }
    }
}

// 编程创建一个 Cale 计算类，在其中定义 2 个变量表示两个操作数，
// 定义四个方法实现求和、差、乘、商（要求除数为 0 的话，要提示）并创建两个对象，分别测试

class Cale {

    double num1, num2;

    public Cale(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // 加法
    public double sum() {
        return num1 + num2;
    }

    // 减法
    public double minus() {
        return num1 - num2;
    }

    // 乘法
    public double mul() {
        return num1 * num2;
    }

    // 除法
    public Double div() {
        if (this.num2 == 0) {
            System.out.println("被除数不能为0");
            return null;
        } else
            return num1 / num2;
    }
}