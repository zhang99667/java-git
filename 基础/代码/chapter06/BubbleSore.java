package chapter06;

public class BubbleSore {
    public static void main(String[] args) {
        // 冒泡排序

        boolean flag = false; // 判断一趟排序下来是否排序，若未排序则已有序
        int arr[] = { 24, 69, 80, 57, 13 };

        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            } 
            if (flag == false)
                break;
        }

        // 输出
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i]);
    }
}
