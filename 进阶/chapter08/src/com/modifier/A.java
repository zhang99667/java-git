package com.modifier;

public class A {
//    public 同包、同类、不同包、子类
//    protected  同包、同类、子类
//    默认 同类、同包
//    private 同类

    //    四个属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public void m1() {
//        使用该方法可以访问 四个属性
        System.out.println("n1=" + n1 + "  n2=" + n2 + "  n3=" + n3 + "  n4=" + n4);
    }

    //protected 修饰符
    protected void m2() {

    }

    //    默认修饰符
    void m3() {
    }

    //    private 修饰符
    private void m4() {

    }
}
