// 使用 for 循环完成下面的案例
// 请编写一个程序，可以接收一个整数，表示层数(totalLevel),打印出金字塔。

package chapter05;

public class Stars {
    public static void main(String[] args) {
        int totalLevel = 10; // 层数

        System.out.println("=====================");
        for (int i = 1; i <= totalLevel; i++) {
            // 控制空格
            for (int j = totalLevel - i; j > 0; j--) {
                System.out.printf(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }

        System.out.println("=====================");

        for (int i = 1; i <= totalLevel; i++) {
            // 控制空格
            for (int j = totalLevel - i; j > 0; j--) {
                System.out.printf(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == totalLevel) {
                    System.out.printf("*");
                } else
                    System.out.printf(" ");
            }

            System.out.printf("\n");
        }

    }
}
