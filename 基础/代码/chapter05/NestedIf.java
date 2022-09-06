package chapter05;

import java.util.Scanner;

public class NestedIf {
    public static void main(String[] args) {
        /*
         * 参加歌手比赛，如果初赛成绩大于8.©进入决赛
         * 否则提示淘汰。并且根据性别提示进入男子组或女子组。
         * 【可以让学员先练习下】，输入成绩和性别，进行判断和输出信息。【 NestedIf.java 】
         * 提示：double score;char gender;
         * 接收字符：char gender=scanner.next().charAt(g)
         */

        Scanner myScanner = new Scanner(System.in);
        System.out.println("please input the score:");
        double score = myScanner.nextDouble();
        if (score > 8.0) {
            System.out.println("please input the gender:");
            char gender = myScanner.next().charAt(0); // String 转换 Char
            if (gender == '男')
                System.out.println("进入男子组");
            else if (gender == '女')
                System.out.println("进入女子组");
            else
                System.out.println("请输入正确的 gender");
        } else
            System.out.println("sorry!");
        myScanner.close(); 
    }
}
