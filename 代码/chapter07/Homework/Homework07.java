package chapter07.Homework;

// 分析流程与结果
public class Homework07 {
    public static void main(String[] args) {
        // 老韩解读
        // 1. new Test() 是匿名对象；匿名对象使用后，就不能使用
        // 2. new Test().count1() 创建好匿名对象后，就调用 count1()
        new Test().count1(); // 未引用，执行完销毁

        Test t1 = new Test();
        t1.count2();
        t1.count2();
    }
}

class Test {
    int count = 9; // 属性

    public void count1() { // Test类的成员方法
        count = 10;
        System.out.println("count1=" + count);
    }

    public void count2() {// Test类的成员方法
        System.out.println("count1=" + count++);
    }
}