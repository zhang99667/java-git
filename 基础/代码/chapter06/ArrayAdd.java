package chapter06;

import java.util.Scanner;

public class ArrayAdd {
    public static void main(String[] args) {
        /*
         * 要求：实现动态的给数组添加元素效果，实现对数组扩容。ArrayAdd.java
         * 1.原始数组使用静态分配int[] arr = { 1,2,3 }
         * 2.增加的元素 4，直接放在数组的最后 arr = { 1,2,3,4 }
         * 3.用户可以通过如下方法来决定是否继续添加，
         * 添加成功，是否继续？ y / n
         */
        Scanner myScanner = new Scanner(System.in);
        int[] arr = { 1, 2, 3 };
        System.out.println("是否继续添加 y/n");
        char state = myScanner.next().charAt(0); // 存放 y/n

        while (state == 'y') {
            int[] arrNew = new int[arr.length + 1]; // 扩容后的数组是原数组大小 + 1
            for (int i = 0; i < arr.length; i++) // 复制原数组到扩容后的数组
                arrNew[i] = arr[i];

            System.out.printf("请输入添加的数字：");
            int n1 = myScanner.nextInt(); // 接收要扩容输入的数字
            arrNew[arrNew.length - 1] = n1; // 把扩容后的最后一个数组的最后一个位置放上数字
            arr = arrNew; // 让 原数组 = 扩容后的数组

            System.out.println("是否继续添加 y/n");
            state = myScanner.next().charAt(0); // 存放 y/n
        }

        for (int i = 0; i < arr.length; i++) // 输出数组
            System.out.printf("%d ", arr[i]);

        myScanner.close();
    }
}
