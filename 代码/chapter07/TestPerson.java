package chapter07;

public class TestPerson {
    public static void main(String[] args) {
        tPerson p1 = new tPerson("jack", 25);
        tPerson p2 = new tPerson("smith", 25);
        System.out.println(p1.compareTo(p2));
        p2.name = "jack";
        System.out.println(p2.compareTo(p1));

    }
}

/*
 * 定义Person类，里面有name、age属性，并提供compareTo比较方法，用于判断
 * 是否和另一个人相等，提供测试类TestPerson.用于测试，名字和年龄完全一样，就
 * 返回true,否则返回false
 */

class tPerson {
    String name;
    int age;

    // 构造器
    public tPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // compareTo比较方法
    public boolean compareTo(tPerson p) {
        // 名字和年龄完全一样
        if (this.name.equals(p.name) && this.age == p.age) {
            return true;
        } else
            return false;
    }
}