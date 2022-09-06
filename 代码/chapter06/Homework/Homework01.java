package chapter06.Homework;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        // 已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序，比如：
        // [10 , 12 , 45 , 90],添加23后，数组为 [10 , 12 , 23 , 45 , 90]
        Scanner myScanner = new Scanner(System.in);

        int[] arr = { 10, 12, 45, 90 };
        int[] newArr = new int[arr.length + 1];
        int index = -1; // 要插入数字的下标

        System.out.println("输入要插入的数字：");
        int insertNum = myScanner.nextInt(); // 输入要插入的数字

        // 定位要插入数字的位置
        for (int i = 0; i < arr.length; i++) {
            if (insertNum <= arr[i]) {
                index = i;
                break;
            }
        }

        // index == -1 说明未找到位置，则把数字插入到最后
        if (index == -1) {
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[newArr.length - 1] = insertNum;
        } else {
            for (int i = 0, j = 0; i < newArr.length; i++) { // j 用来记录新数组当前位置
                if (i == index)
                    newArr[i] = insertNum;
                else
                    newArr[i] = arr[j++];
            }
        }

        arr = newArr;

        // 打印输出
        for (int j = 0; j < arr.length; j++) {
            System.out.printf("%d ", arr[j]);
        }
        myScanner.close();
    }
}