package chapter07;

public class Method01 {
    public static void main(String[] args) {
        // 1方法使用
        // 1·方法写好后，如果不去调用（使用），不会输出
        // 2.先创建对象，然后调用方法即可
        Person p1 = new Person();
        p1.speak();
        p1.cal01();
        p1.cal02(10);
        int returnRes = p1.getSum(10, 20);
        System.out.println("加和结果："+returnRes);
    }

}

class Person {
    String name;
    int age;

    // 方法（成员方法）
    // 添加speak 成员方法，输出“我是一个好人”
    // 老韩解读
    // 1.public 表示方法是公开
    // 2.void I: 表示方法没有返回值
    // 3. speak():speak是方法名， ()形参列表
    // 4。{}方法体，可以写我们要执行的代码
    // 5.System.out.printIn("我是一个好人")； 表示我们的方法就是输出一句话

    public void speak() {
        System.out.println("I'm a nice boy.");
    }

    // 添加ca101成员方法，可以计算从1+..+1000的结果
    public void cal01() {
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            result += i;
        }
        System.out.println("计算结果：" + result);
    }

    // 添加ca12成员方法，该方法可以接收一个数n,计算从1+.+n的结果
    // 1.(int n)形参列表，表示当前有一个形参n,可以接收用户输入
    public void cal02(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += i;
        }
        System.out.println("计算结果：" + result);
    }

    // 添加 getSum 成员方法，可以计算两个数的和
    // 老韩解读
    // 1.pub1ic 表示方法是公开的
    // 2.int:表示方法执行后，返回一个 int
    // 3.getSum 方法名
    // 4.（int num1,int um2）形参列表，2个形参，可以接收用户传入的两个数
    // 5.return result;表示把 result 的值，返回
    public int getSum(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }
}
