package chapter07;

public class This01 {
    public static void main(String[] args) {
        thisDog dog1 = new thisDog("大壮", 3);
        System.out.println("dog1的hashcode=" + dog1.hashCode());

        thisDog dog2 = new thisDog("大黄", 2);
        System.out.println("dog2的hashcode=" + dog2.hashCode());
    }
}

class thisDog {
    String name;
    int age;

    // public thisDog(String pName, int pAge) { // 构造器
    // name = pName;
    // age = pAge;
    // }

    // 如果我们构造器的形参，能够直接写成属性名，就更好了
    // 但是出现了一个问题，根据变量的作用域原则
    // 构造器的 name 是局部变量，而不是属性
    // 构造器的 age 是局部变量，而不是属性
    // 引出 this 关键字 来解决此问题
    public thisDog(String name, int age) {
        // this.name 就是当前对象的属性 name
        this.name = name;
        // this.age 就是当前对象的属性 age
        this.age = age;
        System.out.println("this的hashcode" + this.hashCode());
    }
}
