package com.debug_;

import java.util.Arrays;

public class Debug03 {
    public static void main(String[] args) {
        // debug 的源码
        int[] arr = {8, -1, 199, 70, 10};
        // 排序，追入sort的源码 -> debug 到底层
        Arrays.sort(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
