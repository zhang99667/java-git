package chapter06;

public class ArrayReverse02 {
    int[] arr = { 11, 22, 33, 44, 55, 66 }; // 定义数组

    public static void main(String[] args) {
        int[] arr = { 11, 22, 33, 44, 55, 66 }; // 定义数组
        int[] arr2 = new int[arr.length]; // 存放逆置后的数组
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[arr.length - 1 - i];
        }
        arr = arr2; // arr2 会被当做垃圾，销毁
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
