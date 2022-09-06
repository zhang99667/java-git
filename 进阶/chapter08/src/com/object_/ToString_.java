package com.object_;

public class ToString_ {
    public static void main(String[] args) {

        /*
        Object的toString() 源码
        getClass().getName() 类的全类名（包名 + 类名）
        Integer.toHexstring(hashCode()) 将 hashCode 转换成16进制字符串
        public string tostring () {
            return getclass().getName() + @ +"Integer.toHexstring(hashCode())";
        }
         */

        Monstar monstar = new Monstar("小妖怪", "巡山的", 1000);
        System.out.println(monstar.toString() + monstar.hashCode());
    }
}

class Monstar {
    private String name;
    private String job;
    private double sal;

    public Monstar(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    // 重写toString方法，输出各个对象的属性

    @Override
    public String toString() { // 重写后，一般是把属性输出，也可以自己定制
        return "Monstar{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}