package chapter06;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = { 11, 22, 33, 44, 55, 66 };  // 定义数组
        int temp = arr[0];
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - i - 1] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
