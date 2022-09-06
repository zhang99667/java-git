package chapter07.Homework;

public class Homework05 {
    public static void main(String[] args) {
        Circle cir = new Circle(5);
        System.out.println("周长=" + cir.len());
        System.out.println("面积=" + cir.area());
    }
}

// 定义一个圆类 Circle，
// 定义属性：半径，提供显示圆周长功能的方法，提供显示圆面积的方法
class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() { // 面积
        return Math.PI * radius * radius;
    }

    public double len() {
        return 2 * Math.PI * radius;
    }
}
