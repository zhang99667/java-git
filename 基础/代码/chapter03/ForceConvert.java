package chapter03;
public class ForceConvert {
    public static void main(String[] args) {
        int n1 = (int) 1.9;
        System.out.println("(int) n1 = " + n1); // 1

        int n2 = 2000;
        byte b1 = (byte) n2;
        System.out.println("b1=" + b1);
    }
}
