package Final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        // final 类不能继承，但是可以实例化
        CC cc = new CC();

        new EE().cal();
    }
}

class AA {
    // 1. 定义时
    public static double TAX_RATE = 0.08;
    // 2. 构造器中
    public static double TAX_RATE2;
    public static double TAX_RATE3;

    public AA() {
        TAX_RATE2 = 1.1;
    }

    // 3. 代码块中
    {
        TAX_RATE3 = 1.1;
    }
}

class BB {
    // 如果 final 修饰的属性是静态的，则初始化的位置只能是
    // 1. 定义时
    // 2. 在静态代码块，不能再构造器中赋值
    public static final double TAX_RATE = 99.9;
    public static final double TAX_RATE2;

    // 在类加载时候会进行初始化操作，所以不能为空
    // public static final double TAX_RATE3;

    static {
        TAX_RATE2 = 10.9;
    }
}

// final 类不能继承，但是 可以实例化对象
final class CC {

}

// 如果类不是final类，但是含有final方法，则该类虽然不能重写，但是可以被继承
class DD {
    public final void cal() {
        System.out.println("cal()方法");
    }
}

class EE extends DD {

}