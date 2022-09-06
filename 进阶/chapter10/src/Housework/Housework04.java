package Housework;

/*
 * 1. 计算器接口具有 work 方法，功能是运算，有一个手机类 Cellphone,定义方法 testWork 测试计算功能，调用计算接口的 work 方法，
 * 2. 要求调用 CellPhone 对象的 testWork 方法，使用上 匿名内部类
 *   */
public class Housework04 {
    public static void main(String[] args) {
        // 匿名内部类
        new Cellphone().testWork(new Calculate() {
            @Override
            public int work(int n1, int n2) {
                return n1 + n2;
            }
        }, 10, 10);
    }
}

class Cellphone {
    public void testWork(Calculate calculate, int n1, int n2) {
        System.out.println("result: " + calculate.work(n1, n2));
    }
}

interface Calculate {
    public int work(int n1, int n2);
}