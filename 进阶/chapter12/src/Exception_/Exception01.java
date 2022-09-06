package Exception_;

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        // 老韩解读
        // 1 .num1 / num2 => 10 / 0
        // 2. 当执行到 num1 / num2 因为 num2 = 0, 程序就会出现（抛出）异常 ArithmeticException
        // 3. 当抛出异常后，程序就退出，崩溃了，下面的代码就不在执行
        // 4. 大家想想这样的程序好吗？不好，不应该出现了一个不算致命的问题，就导致整个系统崩溃
        // 5. java设计者，提供了一个叫异常处理机制来解决该问题
        // 如果程序员，认为一段代码可能出现异常/问题，可以使用 try-catch 异常处理机制来解决
        // 从而保证程序的健壮性
        // 选中代码块，按 ctrl + alt + t -> 选中 try-catch

        try {
            int res = num1 / num2;
        } catch (Exception e) {
            System.out.println("出现异常的原因：" + e.getMessage());
        }
        System.out.println("程序继续运行...");
    }
}
