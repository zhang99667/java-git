package Exception_.Housework;

import java.util.Scanner;

// 如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止
public class Housework01 {
    public static void main(String[] args) {
        // 1. 创建 Scanner 对象
        // 2. 使用一个无限循环，去接受一个输入
        // 3. 将该输入的值，转换成一个 int
        // 4. 如果在转换时，抛出异常，说明输入的内容不是一个可以转换 int 的内容
        // 5. 如果没有抛出异常，则 break 该循环
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (true){
            try {
                System.out.println("输入整数：");
                num = Integer.parseInt(scanner.next()); // 这里可能抛出异常
                break;
            } catch (Exception e) {
                System.out.println("你输入的不是一个整数："+e.getMessage());
            }
        }
        System.out.println("你输入的数字是："+num);
    }
}
