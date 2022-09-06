package chapter05.Homework;

public class Homework04 {
    public static void main(String[] args) {
        // 输出小写的a-Z以及大写的Z-A

        for (char c1 = 'a'; c1 <= 'z'; c1++)
            System.out.print(c1 + " ");
        System.out.println("");
        for (char c2 = 'A'; c2 <= 'Z'; c2++)
            System.out.print(c2 + " ");
    }
}
