// 定义一个 Person 类 {name,age,job}
// 初始化Person对像数组，有3个person对像，
// 并按照 age 从大到小进行排序，提示，使用冒泡排序
// Homework01.java


package com.Homework;

public class Homework01 {

    public static void main(String[] args) {
        Person[] persons = {
                new Person("jack", 48, "教授"),
                new Person("smith", 25, "程序员"),
                new Person("mark", 28, "军人")
        };

        new Tools().bubble_sort(persons);

        for (Person person : persons) {
            System.out.println("Name:" + person.getName() + "\tAge:" + person.getAge() + "\tJob:" + person.getJob());
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.setName(name);
        this.setAge(age);
        this.setJob(job);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

class Tools {
    public void bubble_sort(Person[] persons) {
        boolean flag = false;
        for (int i = 0; i < persons.length; i++) {
            for (int j = persons.length - 1; j > i; j--) {
                if (persons[j - 1].getAge() > persons[j].getAge()) {
                    Person temp = persons[j - 1];
                    persons[j - 1] = persons[j];
                    persons[j] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }
}