    package Exception_.CustomException_;

    import java.util.Scanner;

    /*
     * 当我们接收 Person 对象年龄时，要求范围在 18-120 之间，否则抛出一个
     * 自定义异常（要求继承 RuntimeException ),并给出提示信息。
     * */
    public class CustomException {
        public static void main(String[] args) {
            System.out.println("输入年龄，范围 18-120");
            int age = new Scanner(System.in).nextInt();
            if (!(age >= 18 && age <= 120)) {
                // 可以通过构造器设置信息
                throw new AgeException("年龄范围有误"); // 抛出自定义异常
            }
            System.out.println("年龄范围正常");
        }
    }

    // 自定义异常
    // 1. 一般情况下，自定义异常继承 RuntimeException
    // 2. 即把自定义异常做成 运行时异常
    // 3. 即比较方便

    class AgeException extends RuntimeException {
        public AgeException(String message) { // 构造器
            super(message);
        }
    }