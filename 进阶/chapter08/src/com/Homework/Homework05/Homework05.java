// 5.设计父类 —— 员工类。
// 子类：工人类(Worker),农民类(Peasant),教师类(Teacher),科学家类(Scientist),服务生类(Waiter）
// (1) 其中工人，农民，服务生只有基本工资
// (2) 教师除基本工资外，还有课酬（元/天）
// (3) 科学家除基本工资外，还有年终奖
// (4) 编写一个测试类，将各种类型的员工的全年工资打印出来

package com.Homework.Homework05;

public class Homework05 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Worker("jack", 7000),
                new Peasant("mark", 3500),
                new Teacher("tom", 2500, 200, 600),
                new Scientist("trump", 12000, 15, 50000)
        };

        for (Employee employee : employees) {
            employee.printSal();
        }
    }
}