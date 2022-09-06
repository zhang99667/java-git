package chapter07;

import java.util.Scanner;

public class RecursionExercise01 {
    public static void main(String[] args) {

        RecursionExercise re = new RecursionExercise();
        // （1）
        System.out.print("输入大于 1 的数字：");
        Scanner myScanner = new Scanner(System.in);
        System.out.println(re.fibonacci(myScanner.nextInt()));

        // （2）
        System.out.println("有1天桃子 " + re.peach(1) + " 个");

        myScanner.close();
    }
}

class RecursionExercise {
    /*
     * 请使用递归的方式求出斐波那契数1,1,2,3,5,8,13...
     * 给你一个整数n,求出它的值是多少
     */
    public int fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return fibonacci(n - 2) + fibonacci(n - 1);
    }

    /*
     * 猴子吃桃子问题：
     * 有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
     * 以后每天猴子都吃其中的一半，然后再多吃一个。
     * 当到第10天时， 想再吃时（即还没吃），发现只有1个桃子了。
     * 问题：最初共多少个桃子？
     */

    public int peach(int days) {
        if (days == 10)
            return 1;
        else if (days >= 1 && days <= 9)
            return (peach(days + 1) + 1) * 2;
        else {
            System.out.println("days in 1-10");
            return -1;
        }
    }
}
