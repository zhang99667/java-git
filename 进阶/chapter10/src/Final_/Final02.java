package Final_;

public class Final02 {
    public static void main(String[] args) {
        System.out.println(BBB.num);
    }
}

class BBB{
    public static final int num=10000;
    // static 和 final 搭配使用，静态代码块不会执行
    // 故效率更高
    // 静态代码块 会随着类的执行而执行，但是在这里不会
    static {
        System.out.println("BBB 的静态代码快被执行");
    }
}

final class AAA{
    // 因为 AAA 类本身就不能被继承， cry 方法也不能被重写，故 final 修饰无意义
    public final void cry(){}
}

