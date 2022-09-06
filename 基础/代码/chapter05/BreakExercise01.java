package chapter05;

public class BreakExercise01 {
    public static void main(String[] args) {
        // 1-10以内的数求和，求出当和第一次大于20的当前数【for + break】
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            if (sum > 20) {
                System.out.println("sum = " + sum + " 和大于20");
                System.out.println("当前 i = " + i);
                break;
            }
        }
    }
}
