package chapter05.Homework;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        // 判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
        // 例如：153 = 1 * 1 * 1 + 3 * 3 * 3 + 5 * 5 * 5
        Scanner myScanner = new Scanner(System.in);
        System.out.println("输入number:");
        int number = myScanner.nextInt();
        int bai = number / 100; // 百位
        int shi = number % 100 / 10; // 十位
        int ge = number % 10;// 个位
        if (bai * bai * bai + shi * shi * shi + ge * ge * ge == number)
            System.out.println(number + " 是水仙花数！");
        else
            System.out.println(number + " 不是水仙花数！");
        myScanner.close();
    }
}
