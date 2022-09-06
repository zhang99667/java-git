package Wrapper.WrapperExercise;

public class WrapperExercise03 {
    public static void main(String[] args) {
        // 如果有基本数据类型，则 == 判断的是两个数值是否相等
        Integer i1 = 128;
        int i2 = 128;
        System.out.println(i2 == i1); // true

        Integer i3 = 127;
        int i4 = 127;
        System.out.println(i4 == i3); // true
    }
}