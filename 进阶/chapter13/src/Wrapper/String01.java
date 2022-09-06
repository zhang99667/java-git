package Wrapper;

public class String01 {
    public static void main(String[] args) {
        // 1. String 对象用于保存字符串，也就是一组字符序列
        // 2. 字符串常量对象是用 双引号 括起的字符序列
        // 3. 字符串的字符使用 Unicode 字符编码，一个字符（不区分字母还是汉字）占两个字节。
        // 4. String 有很多构造器，实现了构造器的重载
        // 5.String类实现了接口Serializable【String可以串行化：可以在网络传输】
        //                接口Comparable[String对象可以比较大小]
        // 6. String 是 final 类，不能被其他类继承
        // 7. String 有属性， private final char value[]; 用于存放字符串内容
        String name = "jack";
        name = "tom";

        // 8. 一定要注意 value 是一个 final 类型，不可以修改（value 的地址不可修改，但是单个字符内容是可以变化的）
        final char[] value = {'a', 'b'};
        char[] v2 = {'t', 'o', 'm'};
        // value = v2; // Cannot assign a value to final variable 'value'
        // 但是可以修改value的值
        value[0] = 't';
    }
}
