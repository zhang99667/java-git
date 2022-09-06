// 9.设计一个Point类，其x和y坐标可以通过构造器提供。提供一个子类 LabeledPoint,其
// 构造器接授一个标签值和x,y坐标
// 比如：new LabeledPoint("Black",1929,230.07)
// 写出对应的构造器即可Homework09.java
package com.Homework;

public class Homework09 {
    public static void main(String[] args) {
        new LabeledPoint("Black", 1929, 230.07);
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class LabeledPoint extends Point {
    private String Label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        Label = label;
    }
}