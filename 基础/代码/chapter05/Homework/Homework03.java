package chapter05.Homework;

public class Homework03 {
    public static void main(String[] args) {
        // 输 1 - 100 之间的不能被 5 整除的数，每 5 个一行
        int line = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 5 != 0) {
                System.out.printf("%d\t", i);
                line++;
                if (line % 5 == 0)
                    System.out.println("");
            }

        }
    }
}
