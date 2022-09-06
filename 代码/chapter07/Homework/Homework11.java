package chapter07.Homework;

public class Homework11 {
    public static void main(String[] args) {

        Circle11 c = new Circle11();
        PassObject p = new PassObject();
        p.printAreas(c, 5);
    }
}

class Circle11 {
    double radius;

    public double findArea() {
        return Math.PI * this.radius * this.radius;
    }

    // 修改方法 setRadius，修改对象的半径值
    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class PassObject {
    public void printAreas(Circle11 c, int times) {
        System.out.println("Radius" + "\t" + "Area");
        for (int i = 1; i <= times; i++) {
            c.setRadius(i);
            System.out.println((double) i + "\t" + c.findArea());
        }
    }
}
