package com.object_;

public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = a;
        System.out.println(a == c); // true
        System.out.println(b == c); // true

        double num1 = 9.0;
        double num2 = 10.0;

        "hello".equals("Abc");

        Integer integer1 = new Integer(5);
        Integer integer2 = new Integer(5);
        System.out.println(integer1 == integer2); // false
        System.out.println(integer1.equals(integer2)); // true

        String str1 = new String("hspedu");
        String str2 = new String("hspedu");
        System.out.println(str1 == str2); // false
        System.out.println(str1.equals(str2)); // true

    }
}

class A {

}

class B {
}