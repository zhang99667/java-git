package chapter05;

public class DoWhileExercise01 {
    public static void main(String[] args) {
        // 统计1---200之间能被5整除但不能被 3 整除的个数
        int i = 1;
        int count = 0;
        do {
            if (i % 5 == 0 && i % 3 != 0) {
                count++;
                System.out.println(i);
            }
            i++;
        } while (i <= 200);
        System.out.println("个数为：" + count);

    }
}
