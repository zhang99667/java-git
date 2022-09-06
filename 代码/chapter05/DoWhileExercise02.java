package chapter05;

import java.util.Scanner;

public class DoWhileExercise02 {
    public static void main(String[] args) {
        // 如果李三不还钱，则老韩将一直使出五连鞭，直到李三说还钱为止
        // 【System.out.println("老韩问：还钱吗？y/n")】do..while.
        char answer = ' ';
        Scanner myScanner = new Scanner(System.in);
        do {
            System.out.println("老韩问：还钱吗？y/n");
            answer = myScanner.next().charAt(0);
        } while (answer == 'n');
        myScanner.close();

    }
}
