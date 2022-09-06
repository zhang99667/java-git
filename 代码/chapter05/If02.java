package chapter05;
import java.util.Scanner;

public class If02 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = myScanner.nextInt();
        if (age >= 18)
            System.out.println("年龄大于等于 18 岁！");
        else
            System.out.println("年龄小于 18 岁！");
        myScanner.close();
    }
}
