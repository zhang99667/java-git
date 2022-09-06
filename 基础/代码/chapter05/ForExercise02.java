package chapter05;

public class ForExercise02 {
    public static void main(String[] args) {
        /*
         * 输出：
         * 0 + 5 = 5
         * 1 + 4 = 5
         * 2 + 3 = 5
         * 3 + 2 = 5
         * 4 + 1 = 5
         * 5 + 0 = 5
         */
        int start = 0;
        int end = 5;
        for (int i = start; i <= end; i++) {
            System.out.println(i + " + " + (end - i) + " = " + end);
        }
    }
}
