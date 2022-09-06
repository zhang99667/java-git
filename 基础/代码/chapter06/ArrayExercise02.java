package chapter06;

public class ArrayExercise02 {
    public static void main(String[] args) {
        // 请求出一个数组int[] 的最大值 {4,-1,9,10,23}，并得到对应的下标

        int[] numbers = { 4, -1, 9, 10, 23 };
        int max = numbers[0];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                index = i;
            }
        }
        System.out.println("max number = " + max);
        System.out.println("max number index = " + index);
    }
}
