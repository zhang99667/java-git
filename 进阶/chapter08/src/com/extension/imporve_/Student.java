package com.extension.imporve_;

// 父类， Pupil 和 Graduate 的父类
public class Student {
    public String name;// 姓名
    public int age;// 年龄
    private double score;// 成绩

    public void setScore(double score) {
        this.score = score;
    }

    public void showInfo(){
        System.out.println("姓名："+name+" 年龄 "+age+" 成绩 "+score);
    }
}
