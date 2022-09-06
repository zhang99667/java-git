package chapter06.Homework;

public class Homework03 {
    public static void main(String[] args) {

        // 冒泡排序
        int[] arr = { 20, -1, 89, 2, 890, 7 }; // 排序的数组

        boolean flag = false; // 判断一趟排序是否有交换

        for (int i = 0; i < arr.length; i++) {
            flag = false; // 每一趟排序后重置 flag
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) // 若一趟无排序，则数组有序
                break;
        }

        // 输出数组
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i]);
    }
}