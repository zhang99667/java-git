package Wrapper.WrapperExercise;

public class WrapperExercise01 {
    public static void main(String[] args) {
        Object obj1 = true ? new Integer(1) : new Double(2.0); // 三元运算符
        System.out.println(obj1); // 1.0，因为三元运算符是一个整体，整体中有一个精度更高的选项 Double，故为1.0

        Object obj2;
        if (true)
            obj2 = new Integer(1);
        else
            obj2 = new Double(2.0);
        System.out.println(obj2); // 1
    }
}

