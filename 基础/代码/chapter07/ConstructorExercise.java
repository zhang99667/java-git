package chapter07;

public class ConstructorExercise {
    public static void main(String[] args) {

        conPerson02 p1 = new conPerson02();
        System.out.println("name = " + p1.name + " ; age = " + p1.age); // name = null ; age = 18

        conPerson02 p2 = new conPerson02("scott", 50);
        System.out.println("name = " + p2.name + " ; age = " + p2.age); // name = scott ; age = 50
    }
}

/*
 * 在前面定义的Person类中添加两个构造器：
 * 第一个无参构造器：利用构造器设置所有人的 age 属性初始值都为 18
 * 第二个带 pName 和 pAge 两个参数的构造器
 * 使得每次创建 Person 对象的同时初始化对象的 age 属性值和 name 属性值。
 * 分别使用不同的构造器，创建对象.
 */
class conPerson02 {
    String name;
    int age;

    // * 第一个无参构造器：利用构造器设置所有人的 age 属性初始值都为 18
    public conPerson02() {
        age = 18;
    }

    // * 第二个带 pName 和 pAge 两个参数的构造器
    public conPerson02(String pName, int pAge) {
        name = pName;
        age = pAge;
    }

}
