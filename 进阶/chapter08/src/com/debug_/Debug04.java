package com.debug_;

import java.util.Arrays;

// 演示执行到下一个断点，同时支持动态
public class Debug04 {
    public static void main(String[] args) {
        // debug 的源码
        int[] arr = {8, -1, 199, 70, 10};
        // 排序，追入sort的源码 -> debug 到底层
        Arrays.sort(arr);
        for (int j : arr) {
            System.out.println(j);
        }

        System.out.println("hello100");
        System.out.println("hello200");
        System.out.println("hello300");
        System.out.println("hello400");
        System.out.println("hello500");
        System.out.println("hello600");
        System.out.println("hello700");
        System.out.println("hello800");
    }
}

