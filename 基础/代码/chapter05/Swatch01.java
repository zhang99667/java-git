package chapter05;

import java.util.Scanner;

public class Swatch01 {

    /*
     * 案例：Switch01.java
     * 请编写一个程序，该程序可以接收一个字符，比如：a,b,c,d,e,f,g
     * a表示星期一，b表示星期二
     * 根据用户的输入显示相应的信息.要求使用switch语句完成
     */
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("please input 'a-g'");
        char c1 = myScanner.next().charAt(0);
        switch (c1) {
            case 'a':
                System.out.println("今天星期一，猴子穿新衣");
                break;
            case 'b':
                System.out.println("今天星期二，猴子当小二");
                break;
            case 'c':
                System.out.println("今天星期三，猴子爬雪山");
                break;
            default:
                System.out.println("输入有误！不匹配！");
        }
        System.out.println("退出 switch，程序继续执行。");
        myScanner.close();
    }
}