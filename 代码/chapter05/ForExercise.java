package chapter05;

public class ForExercise {
    public static void main(String[] args) {
        // 打印1 ~ 100之间所有是9的倍数的整数，统计个数及总和.【化繁为简，先死后活】
        int count = 0; // 个数
        int sum = 0; // 和
        int start = 1; // 起点
        int end = 100; // 终点
        int t = 9; // 倍数
        for (int i = start; i <= end; i++) {
            if (i % t == 0) {
                System.out.println(i);
                sum += i;
                count++;
            }
        }
        System.out.println("共计：" + count + "个");
        System.out.println("和：" + sum);
    }
}
