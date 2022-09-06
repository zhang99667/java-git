package com.pkg;

// import java.util.Scanner;  表示只会导入java.util 包下的 Scanner
// import java.util.*;  表示将 Java.util 包下的所有类都引入（导入）

import java.util.Arrays;

public class Import01 {
    public static void main(String[] args) {
        int[] arr = {-1, 20, 2, 13, 3};
        //    比如排序
        //    传统方法是，自己编写排序（冒泡）
        //    系统提供了相关的类，可以方便完成 Arrays
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
