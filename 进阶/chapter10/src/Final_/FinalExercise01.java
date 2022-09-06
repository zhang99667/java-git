package Final_;

// 请编写一个程序，能够计算圆形的面积。要求圆周率为 3.14.
// 赋值的位置 3 个方式都写一下.
public class FinalExercise01 {
    public static void main(String[] args) {
        System.out.printf("%.2f\n", new Circle(3).Calculate());
    }
}

class Circle {
    private double radius; // 半径
    // 第一种，在定义中赋值
    private final double PI = 3.14;

    // 第二种静态代码块中赋值
    // static {
    //     PI = 3.14;
    // }

    public Circle(double radius) {
        this.radius = radius;
        // 第三种，构造器中赋值
        // PI = 3.14;
    }

    public double Calculate() {
        return PI * radius * radius;
    }
}