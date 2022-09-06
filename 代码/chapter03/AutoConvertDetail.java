package chapter03;
/**
 * AutoConvertDetail
 */
public class AutoConvertDetail {
    public static void main(String[] args) {
        int n1 = 10; // ok
        // float d1 = n1 + 1.1; // 错误 n1 + 1.1 => 结果类型为 double
        double d1 = n1 + 1.1; // 对 n1 + 1.1 => 结果类型是 double
        float d2 = n1 + 1.1F; // 正确
        System.out.println(d1);
        System.out.println(d2);

        // 细节2：
        // 当我们把精度（容量）大的数据类型赋值给精度（容量）小的数据类型时
        // 就会报错，反之就会进行自动类型转换。
        // int n2 = 1.1; // 错误double->int

        // 细节3：
        // (byte,short)和char之间不会相互自动转换
        // 当把数赋给byte时，(1)先判断该数是否在byte范围内，如果是就可以
        byte b1 = 10; // -128 - 127
        System.out.println(b1);
        // int n2 = 1;// n2是int
        // byte b2 = n2; // 错误，原因：如果是变量赋值，判断类型
        // char c1 = b1;//错误，原因 byte 不能自动转成 char

        // 细节4：byte,short,char他们三者可以计算，在计算时首先转换为int类型
        byte b2 = 1;
        short s1 = 1;
        // short s2 = b2 + s1; // 错，b2 + s1 => int
        int s2 = b2 + s1; // 错，b2 + s1 => int
        System.out.println(s2);

        // boolean不参与转换
        boolean pass = true;
        // int num100 = pass; // 错，boolean 类型不参与自动转换
        System.out.println(pass);

        // 自动提升原则：表达式结果的类型自动提升为操作数中最大的类型
        // 看一道题
        byte b4 = 1;
        short s3 = 100;
        int num200 = 1;
        float num300 = 1.1F;
        System.out.println(b4 + s3 + num200 + num300);
    }
}