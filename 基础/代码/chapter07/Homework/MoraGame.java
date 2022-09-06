package chapter07.Homework;

import java.util.Random;
import java.util.Scanner;

public class MoraGame {
    public static void main(String[] args) {
        Computer comp = new Computer();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("请输入你要出的拳（0表示石头；1表示剪刀；2表示布。）：");
            int tomGuessNum = scanner.nextInt(); // 用户出拳类型
            int comGuessNum = comp.getComGuessNum(); // 电脑出拳类型
            comp.compare(tomGuessNum, comGuessNum, comp); // 判断是否胜利
        }

        comp.showInfo(); // 显示游戏结果
        scanner.close();
    }
}

/*
 * 请编写一个猜拳的游戏
 * 有个人 Tom，设计他的成员变量：成员方法，可以电脑猜拳。电脑每次都会随机生成 0，1，2
 * 0表示石头；1表示剪刀；2表示布
 * 并要可以显示Tom的输赢次数（清单），假定玩三次.
 */

class Computer {
    int count = 0; // 记录一共进行了几局游戏
    char[] MoraGame = new char[3]; // 记录胜负
    int[] comGuess = new int[3]; // 记录电脑出拳
    int[] tomGuess = new int[3]; // 记录tom出拳

    // 记录
    public void save(int count, int comGuessNum, int tomGuessNum, char isWinner) {
        this.MoraGame[count] = isWinner;
        this.comGuess[count] = comGuessNum;
        this.tomGuess[count] = tomGuessNum;
    }

    // 判断
    public void compare(int tomGuessNum, int comGuessNum, Computer comp) {
        if (tomGuessNum >= 0 && tomGuessNum <= 2) { // 输入正确的类型
            // 判断逻辑
            if (tomGuessNum == 0 && comGuessNum == 1) { // tom石头 -> com剪刀
                comp.save(count, comGuessNum, tomGuessNum, '胜');
                System.out.println("第" + (count + 1) + "局，你赢了电脑！");
            } else if (tomGuessNum == 1 && comGuessNum == 2) { // tom剪刀 -> com布
                comp.save(count, comGuessNum, tomGuessNum, '胜');
                System.out.println("第" + (count + 1) + "局，你赢了电脑！");
            } else if (tomGuessNum == 2 && comGuessNum == 0) {
                comp.save(count, comGuessNum, tomGuessNum, '胜');
                System.out.println("第" + (count + 1) + "局，你赢了电脑！");
            } else if (tomGuessNum == comGuessNum) { // 平局
                comp.save(count, comGuessNum, tomGuessNum, '平');
                System.out.println("第" + (count + 1) + "局，平局！");
            } else {
                comp.save(count, comGuessNum, tomGuessNum, '负');
                System.out.println("第" + (count + 1) + "局，你输了电脑！");
            }
        } else
            System.out.println("输入有误！");
        count++;
    }

    // 获取电脑出拳情况
    public int getComGuessNum() {
        Random r = new Random();
        int comGuessNum = r.nextInt(3);
        return comGuessNum;
    }

    public void showInfo() {
        System.out.println("==========================================");
        System.out.println("对局\ttom\t电脑\t胜负");
        for (int i = 0; i < MoraGame.length; i++) {
            System.out.println((i + 1) + "\t" + tomGuess[i] + "\t" + comGuess[i] + "\t" + MoraGame[i]);
        }

        int winnerCount = 0; // 记录胜场
        for (int i = 0; i < MoraGame.length; i++)
            if (MoraGame[i] == '胜')
                winnerCount++;

        System.out.println("玩家一共赢了" + winnerCount + "局！");
        System.out.println("===========================================");
    }
}
