package Exception_.Throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) {

    }
    public void f1() throws FileNotFoundException,NullPointerException,ArithmeticException{
        // 创建了一个文件流对象
        // 1. 这里的异常是一个 FileNotFoundException 编译异常
        // 2. 使用前面的 try-catch-finally
        // 3. 使用 throws，抛出异常.让调用 f1 方法的调用者（方法）处理
        // 4. throws 后面的异常类型可以是方法中产生的异常类型，也可以是他的父类
        // 5. throws 关键字后也可以是 异常列表，即抛出多个异常
        FileInputStream fileInputStream = new FileInputStream("D://a.txt");
    }
}

