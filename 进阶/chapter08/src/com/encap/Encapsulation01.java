package com.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person jack = new Person();
        jack.setName("jack");
        jack.setAge(30);
        jack.setSalary(25000.0);
        System.out.println(jack.info());
        System.out.println(jack.getSalary());
        System.out.println(jack.getAge());

        Person smith = new Person("smith", 15, 30000);
        System.out.println(smith.info());
    }
}

// 请大家看一个小程序(Encapsulation01.java)
// 不能随便查看人的年龄，工资等隐私，并对设置的年龄进行合理的验证。
// 年龄合理就设置，否则给默认年龄，必须在1-120，年龄，工资不能直接查看，name的长度在2-6之间

class Person {
    public String name; // 姓名
    private int age; // 年龄
    private double salary; // 薪水

    public Person() { // 无参构造器
    }

    public Person(String name, int age, double salary) { // 可以将构造器与 setXxx 结合
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void setName(String name) {
        // 数据校验，相当于增加了业务逻辑
        if (name.length() >= 2 && name.length() <= 6) this.name = name;
        else {
            System.out.println("名字长度有误，需要 2-6 个字符，默认名字为空");
            this.name = "none";
        }
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        // 判断年龄是否在合理范围
        if (age >= 1 && age <= 120) this.age = age;
        else {
            System.out.println("你设置的年龄有误，需要在 1-120 之间。默认年龄 18");
            this.age = 18;
        }
    }

    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        // 可以增加对当前对象的权限判断
        return salary;
    }

    // 返回个人信息
    public String info() {
        return "name = " + name + " age = " + age + " salary = " + salary;
    }
}
