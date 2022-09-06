package chapter04;

public class LogiclOperator01 {
    public static void main(String[] args) {
        // && 和 &
        int age = 50;
        if (age > 20 && age < 90) {
            System.out.println("ok100");
        }

        // & 使用
        if (age > 20 & age < 40) {
            System.out.println("ok200");
        }

        // 区别
        int a = 4;
        int b = 9;
        // 对于&&短路与而言，如果第一个条件为false,后面的条件不再判断
        // 对于&逻辑与而言，如果第一个条件为fa1se,后面的条件仍然会判断
        if (a < 1 & ++b < 50) {
            System.out.println("ok300");
            System.out.println("a=" + a + "b=" + b);// 4 9
        }
    }
}