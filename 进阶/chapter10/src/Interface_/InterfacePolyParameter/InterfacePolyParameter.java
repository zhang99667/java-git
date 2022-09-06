package Interface_.InterfacePolyParameter;

public class InterfacePolyParameter {
    public static void main(String[] args) {
        // 接口的多态体现
        // 接口类型变量 if01 可以指向 实现了 if 接口的对象实例
        IF if01 = new Monster();
        if01 = new Car();

        // 继承体现的多态
        AAA a = new BBB();
        a = new CCC();
    }


}

interface IF {
}

class AAA {
}

class BBB extends AAA {
}

class CCC extends AAA {
}

class Monster implements IF {
}

class Car implements IF {
}