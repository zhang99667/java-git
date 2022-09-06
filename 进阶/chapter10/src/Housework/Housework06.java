package Housework;

/*
 *
 * 1. 有一个交通工具接口类 Vehicles,有 work 接口
 * 2. 有 Horse 类和 Boat 类分别实现 Vehicles
 * 3. 创建交通工具工厂类，有两个方法分别获得交通工具 Horse 和 Boat
 * 4. 有 Person 类，有 name 和 Vehicles 属性，在构造器中为两个属性赋值
 * 5. 实例化 Person 对象“唐僧”，要求一般情况下用 Horse 作为交通工具，遇到大河时用 Boat 作为交通工具
 *
 *  */

public class Housework06 {
    public static void main(String[] args) {
        Person tangSan = new Person("tangSan", new Horse());
        tangSan.Common();
        tangSan.passRiver();
        tangSan.Mountain();
    }


}

// 交通工具工厂类
class Factor {
    // 保证每次都是同一匹马
    private static Horse horse = new Horse(); // 饿汉式 单例
    // 保证每次都是同一艘船
    private static Boat boat = new Boat(); // 饿汉式 单例
    // 保证每次都是同一架飞机
    private static Plane plane = new Plane(); // 饿汉式 单例

    // 得到马
    public static Vehicles getHorse() {
        return horse;
    }

    // 得到船
    public static Vehicles getBoat() {
        return boat;
    }

    // 得到飞机
    public static Vehicles getPlane() {
        return plane;
    }
}

// 人类
class Person {
    private String name;
    private Vehicles vehicles; // 交通工具

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    // 过河
    public void passRiver() {
        // 判断当前的 vehicle 是不是船
        // 如果 vehicle 为 null，则 instanceof 会返回 false
        // 如果 vehicle 不是 horse 也会返回 false
        if ((this.vehicles instanceof Boat) == false) {
            this.vehicles = Factor.getBoat();
        }
        this.vehicles.work();
    }

    // 一般情况
    public void Common() {
        // 判断当前的 vehicle 属性是否已经存在
        if ((this.vehicles instanceof Horse) == false) {
            // 使用多态
            this.vehicles = Factor.getHorse();
        }
        // 体现使用接口调用
        this.vehicles.work();
    }

    public void Mountain() {
        if ((this.vehicles instanceof Plane) == false) {
            this.vehicles = Factor.getPlane();
        }
        this.vehicles.work();
    }
}

class Horse implements Vehicles {

    @Override
    public void work() {
        System.out.println("普通情况要驾马...");
    }
}

class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("过河要驾船...");
    }
}

class Plane implements Vehicles {

    @Override
    public void work() {
        System.out.println("过火焰山要驾飞机...");
    }
}


interface Vehicles {
    public void work();
}