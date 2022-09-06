package chapter04;
public class ArithmeticOperator {
    public static void main(String[] args) {
        // / 的使用
        System.out.println(10 / 4); // 2
        System.out.println(10.0 / 4); // 2.5
        double d = 10 / 4; // 2 -> 2.0
        System.out.println(d);

        // % 取模
        // 在 % 的本质看一个公式a % b = a - a / b * b;
        // -10 % 3 => -10 - (-10) / 3 * 3 = -10 + 9 = -1;
        System.out.println(10 % 3); // 1\
        System.out.println(-10 % 3); // -1
        System.out.println(10 % -3); // 1
        System.out.println(-10 % -3); // -1

        // ++ 的使用
        int i = 10;
        i++; // 自增
        ++i; // 自增
        System.out.println("i = " + i); // 12

        /*
         * 作为表达式使用
         * 前++：++i先自增后赋值
         * 后++：i++先赋值后自增
         */
        int j = 8;
        int k = ++j;// 等价 j = j + 1; k = j;
        System.out.println("k = " + k + "j = " + j); // 9 9

    }
}