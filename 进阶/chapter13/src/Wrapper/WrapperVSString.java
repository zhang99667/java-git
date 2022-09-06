package Wrapper;

public class WrapperVSString {
    public static void main(String[] args) {
        // 包装类 (Integer) -> String
        Integer i = 100; // 自动装箱
        // 方式1
        String str1 = i + "";
        // 方式2
        String str2 = i.toString();
        String str3 = String.valueOf(i);

        // String -> 包装类(Integer)
        String str4 = "1234";
        Integer i1 = Integer.parseInt(str4); // 自动装箱
        Integer i2 = new Integer(str3); // 构造器


    }
}

