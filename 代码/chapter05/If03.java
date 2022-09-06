package chapter05;

import java.util.Scanner;

public class If03 {
    public static void main(String[] args) {
        /*
         * 输入保国同志的芝麻信用分：
         * 如果：
         * 信用分为100分时，输出信用极好
         * 信用分为(80,99]时，输出信用优秀
         * 信用分为[60,80]时，输出信用一般；
         * 其它情况，输出信用不及格
         * 请从键盒输入保国的芝麻信用分，并加以判断
         * 假是信用分数为int
         */

        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入信用分 1 - 100：");
        int grade = myScanner.nextInt();
        if (grade <= 100 && grade >= 0) {

            if (grade == 100)
                System.out.println("信用极好！");
            else if (grade > 80 && grade <= 99)
                System.out.println("信用优秀");
            else if (grade >= 60 && grade < 80)
                System.out.println("信用一般");
            else
                System.out.println("信用不及格");
            myScanner.close();
        } else
            System.out.println("信用分需要在1 - 100，请重新输入！");
    }
}
