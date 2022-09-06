// (1)做一个Student类，Student类有名称(name)性别(sex),年龄(age),学号(stu id)
//     ，做合理封装，通过构造器在创建对象时将4个 属性赋值。
// (2)写一个Teacher类，Teacher类有名称(name)性别(sex)年龄(age),
//     工龄(work age),做合理封装，通过构造器在创建对象时将4个 属性赋值。
// (3)抽取一个父类Person类，将共同属性和方法放到Person类
// (4)学生需要有学习的方法(study)在方法里写生“我承诺，我会好好学习。
// (5)教师需要有教学的方法(teach)在方法里写上“我承诺，我会认真教学。
// (6)学生和教师都有玩的方法(play)学生玩的是足球，老师玩的是象棋
//     此方法是返回字符串的，分别返回“Xx爱玩足球”和“x爱玩象棋”
//     (其中xx分别代表学生和老师的姓名)。因为玩的方法名称都一样，所以要求
//     此方法定义在父类中，子类实现重写
// (7)定义多态数组，里面保存2个学生和2个教师，要求按年龄从高到低排序
// (8)定义方法，形参为Person.类型，功能：调用学生的study或教师的 teach方法
package com.Homework.Homework13;

public class Homework13 {
    public static void main(String[] args) {
        Person[] persons = {
                new Student("jack", '男', 20, 1),
                new Student("trump", '男', 21, 2),
                new Student("rose", '女', 20, 3),
                new Student("mark", '男', 19, 4),

                new Teacher("tom", '男', 30, 10),
                new Teacher("bill", '男', 48, 20),
                new Teacher("cook", '男', 59, 25),
                new Teacher("Jimmy ", '男', 58, 31)
        };

        Tools tools = new Tools();
        tools.bubble_sort(persons);

        for (int i = persons.length - 1; i > 0; i--) {
            persons[i].printInfo();
            tools.test(persons[i]);
            System.out.println("=============================");
        }
    }
}


class Tools {
    public void test(Person p) {
        if (p instanceof Student)
            ((Student) p).study();
        else if (p instanceof Teacher)
            ((Teacher) p).teach();
        else
            System.out.println("do nothing....");
    }

    public void bubble_sort(Person[] persons) {
        boolean flag;
        for (int i = 0; i < persons.length; i++) {
            flag = false;
            for (int j = persons.length - 1; j > i; j--) {
                if (persons[j - 1].getAge() > persons[j].getAge()) {
                    Person temp = persons[j];
                    persons[j] = persons[j - 1];
                    persons[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}