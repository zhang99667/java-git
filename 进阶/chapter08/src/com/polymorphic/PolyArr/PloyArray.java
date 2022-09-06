package com.polymorphic.PolyArr;

public class PloyArray {
    public static void main(String[] args) {
        // 应用实例：现有一个继承结构如下：要求创建1个Person对象
        // 2个Student对象和2个Teacher对象，统一放在数组中，并调用每个对象say方法

        Person[] persons = new Person[5];
        persons[0] = new Person("tom", 20);
        persons[1] = new Student("jack", 18, 99);
        persons[2] = new Student("smith", 18, 88);
        persons[3] = new Teacher("scott", 30, 25000);
        persons[4] = new Teacher("king", 30, 20000);

        // persons[i] 编译类型是 Person ，运行类型是根据实际情况来JVM判断
        for (Person person : persons) {
            System.out.println(person.say());

            /*
             可以写成两步：
             Student student = (Student) persons[i];
             student.study();
            */
            if (person instanceof Student) ((Student) person).study();

                /*
                 可以写成两步：
                 Teacher teacher=(Teacher) persons[i];
                 teacher.teach();
                */
            else if (person instanceof Teacher) ((Teacher) person).teach();
        }

    }
}


