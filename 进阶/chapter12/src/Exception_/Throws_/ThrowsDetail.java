package Exception_.Throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilePermission;

public class ThrowsDetail {
    public static void main(String[] args) {
        f2();
    }

    public static void f2() throws ArithmeticException {
        // 1. 对于 **编译异常**，程序中 **必须处理**，比如 try-catch 或者 throws
        // 2. 对于 **运行时异常**，程序中如果没有处理，默认 就是 throws 的方式处理

        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;
    }

    public static void f1() throws FileNotFoundException {
        // 这里调用 f3 方法会报错
        // 1. 因为 f3 方法跑出的异常是一个编译异常
        // 2. 即这时，就要求 f1() 必须处理这个编译异常
        // 3. 编译异常必须处理，所有要给他 try-catch 括起来，或者继续 throws 这个编译异常
        /*
         try {
            f3(); // 抛出异常
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
         */
        f3();
    }

    public static void f3() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D://a.txt");
    }

    public static void f4(){
        // 1. f4() 中调用 f5() 不会发生异常
        // 2. 因为 f5() 抛出的是运行异常
        // 3. java 中，并不要求程序要显示处理运行异常，因为有默认处理机制

        f5();
    }

    public static void f5() throws ArithmeticException{}
}

// 父类
class Father {
    public void method() throws RuntimeException {
    }
}

// 子类
class Son extends Father {
    // 3. 子类重写父类的方法时，对抛出异常的规定：子类重写的方法，所抛出的异常类型要么和父类抛出的异常
    //    一致，要么为父类抛出的异常的类型的 子类型
    // 在 throws 过程中，如果有方法 try-catch 就相当于处理异常，就可以不必 throws
    @Override
    // public void method() throws Exception { //  overridden method does not throw 'java.lang.Exception'
    public void method() throws ArithmeticException { // 这里 throws RuntimeException 或者其子类都可以
        super.method();
    }
}