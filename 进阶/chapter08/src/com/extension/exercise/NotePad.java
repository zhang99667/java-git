package com.extension.exercise;

public class NotePad extends Computer {
    private String Color;

    public NotePad(String CPU, int memory, int disk, String color) {
        super(CPU, memory, disk);
        this.Color = color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getColor() {
        return Color;
    }

    public void printInfo() {
        System.out.println("NotePad信息如下：");
        System.out.println(getDetails() + " Color: " + getColor());
    }
}
