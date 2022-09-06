package chapter04;
// 演示接受用户的输入
// 步骤
// 1.引入/导入Scanner类所在的包
// Scanner类表示简单文本扫描器，在java.util包
import java.util.Scanner; // 表示把 java.util 下的 Scanner 类导入

public class Input {
    public static void main(String[] args) {
        // 2.创建Scanner对象
        Scanner myScanner = new Scanner(System.in);

        // 3.接受用户的输入；使用相关的方法
        System.out.println("请输入名字：");
        String name = myScanner.next(); // 接受用户输入
        System.out.println("请输入年龄：");
        int age = myScanner.nextInt(); // 接受用户输入
        System.out.println("请输入薪水：");
        double sal = myScanner.nextInt(); // 接受用户输入
        System.out.println("人的信息如下：");
        System.out.println("name = "+name +"\t age = "+age +"\t sal = "+sal);
        myScanner.close();
    }
}
