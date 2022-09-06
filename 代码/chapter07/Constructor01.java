package chapter07;

public class Constructor01 {
    public static void main(String[] args) {
        conPerson p1 = new conPerson("smith", 80);
        System.out.println("p1信息：");
        System.out.println("name = " + p1.name + " & age = " + p1.age);
    }
}

// 在创建人类的对象时，直接制定这个对象的年龄和姓名
class conPerson {
    String name;
    int age;

    // 构造器：
    // 老韩解读：
    // 1. 构造器没有返回值，也不能写 void
    // 2. 构造器的名称和类 conPerson 一样
    // 3. (String pName,int pAge) 是构造器形参列表，规则和成员方法一样
    public conPerson(String pName, int pAge) {
        System.out.println("构造器被调用，完成对象属性初始化！");
        name = pName;
        age = pAge;
    }
}
