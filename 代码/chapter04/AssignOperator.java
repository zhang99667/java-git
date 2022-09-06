package chapter04;

public class AssignOperator {
    public static void main(String[] args) {
        // 赋值运算的使用

        int n1 = 10;
        n1 += 4;
        System.out.println(n1); // 14
        n1 /= 3;
        System.out.println(n1); // 4

        // 复合赋值运算符会进行类型转换
        byte b = 3;
        b += 2; // b = (byte) (b + 2);
        System.out.println(b);
    }
}
