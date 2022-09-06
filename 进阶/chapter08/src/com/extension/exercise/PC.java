package com.extension.exercise;

public class PC extends Computer {
    private String Brand;

    // 体现了：继承设计的基本思想，父类的构造器完成父类属性初始化
    // 子类的构造器完成子类属性初始化
    public PC(String CPU, int memory, int disk, String brand) {
        super(CPU, memory, disk);
        this.Brand = brand;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public String getBrand() {
        return Brand;
    }

    public void printInfo() {
        System.out.println("PC的信息：");
        System.out.println(getDetails() + " Brand: " + getBrand());
    }
}
