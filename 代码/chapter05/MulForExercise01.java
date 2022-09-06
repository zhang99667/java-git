package chapter05;

import java.util.Scanner;

public class MulForExercise01 {
    public static void main(String[] args) {
        // 统计3个班成绩情况，每个班有5名同学
        // 求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。
        // 统计三个班及格人数，每个班有5名同学。
        Scanner myScanner = new Scanner(System.in);
        int totalScore = 0; // 学生总成绩
        int passNum = 0; // 累计 及格人数
        int classNum = 5; // 班级数量
        int stuNum = 5; // 学生数量

        for (int i = 1; i <= classNum; i++) {

            int sum = 0; // 每个班级的成绩

            for (int j = 1; j <= stuNum; j++) {
                System.out.println("请输入第 " + i + " 个班的第 " + j + " 个学生输入成绩：");
                double score = myScanner.nextDouble(); // 学生成绩
                if (score >= 60) // 判断及格人数
                    passNum++;
                System.out.println("成绩为：" + score);
                totalScore += score; // 总成绩求和
                sum += score;
            }

            System.out.println("==============================");
            System.out.println(i + " 班的总分为：" + (double) sum);
            System.out.println(i + " 班的平均分为：" + (double) (sum / stuNum));
            System.out.println("==============================");
        }

        System.out.println("==============================");
        System.out.println("总分为：" + (double) totalScore);
        System.out.println("平均分为：" + (double) totalScore / (stuNum * classNum));
        System.out.println("及格人数为：" + passNum);
        myScanner.close();
    }
}
