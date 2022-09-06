package chapter05;

import java.util.Scanner;

public class SwatchExercise {
    public static void main(String[] args) {
        // 使用switch把小写类型的
        // char型转为大写（键盘输入）。只转换a->A,b->B,c-C,d->D,e->E其它的输出 other
        Scanner myScanner = new Scanner(System.in);
        char c = myScanner.next().charAt(0);
        switch (c) {
            case 'a':
                System.out.println("A");
                break;
            case 'b':
                System.out.println("B");
                break;
            case 'c':
                System.out.println("C");
                break;
            case 'd':
                System.out.println("D");
                break;
            case 'e':
                System.out.println("E");
                break;
            default:
                System.out.println("输入有误！");
                break;
        }

        // 对学生成绩大于60分的，输出"合格”。低于60分的，
        // 输出"不合格"。（注：输入的成绩不能大于100），提示成绩 / 60
        double score = 88.5;
        switch ((int) score / 60) {
            case 1:
                System.out.println("合格");
                break;
            case 0:
                System.out.println("不合格");
                break;
            default:
                System.out.println("请重新输入");
                break;
        }

        // 根据用于指定月份，
        // 打印该月份所属的季节。
        // 3,4,5春季6,7,8夏季9,10,11秋季12,1,2冬季
        // [课堂练习，提示使用穿透]

        System.out.println("input month");
        int month = myScanner.nextInt();
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("autumn");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("winter");
                break;
            default:
                System.out.println("error input");
                break;
        }
        myScanner.close();
    }
}
