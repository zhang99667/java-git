package chapter05.Homework;

public class Homework01 {
    public static void main(String[] args) {
        /*
         * 某人有100,000元，每经过一次路口，需要交费，规则如下：
         * 1)当现金>50000时，每次交5%
         * 2)当现金<=50000时，每次交1000
         * 编程计算该人可以经过多少次路口，要求：使用while + break方式完成
         */

        double money = 100000; // 钱
        int count = 0; // 记录通过路口
        while (money > 0) {
            if (money > 50000) {
                money = money * 0.95; // 每次交 5%
                count++;
            } else if (money >= 1000) {
                money = money - 1000; // 每次扣除 1000
                count++;
            } else
                break;
        }
        System.out.println("通过了 " + count + " 个路口");
        System.out.println("还有 " + money + " 元");
    }
}
