package com.polymorphic.Exercise;

public class PolyExercise01 {
    public static void main(String[] args) {
        double d = 13.4;
        long l = (long) d;
        System.out.println(l);// 13

        // int in = 5;
        // boolean b = (boolean) in; // 不ok，int 和 boolean 无父子类关系

        Object obj = "Hello"; // String -> Object 向上转型
        String objStr = (String) obj; // Object -> String 向下转型
        System.out.println(objStr); // Hello

        Object objPri = new Integer(5); // Integer -> Object 向上转型
        String str = (String) objPri;// 错误ClassCastException,指向Integer的父类引用，转成String
        Integer str1 = (Integer) objPri;

    }
}
