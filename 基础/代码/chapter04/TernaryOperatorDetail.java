package chapter04;

public class TernaryOperatorDetail {
    public static void main(String[] args) {
        int a = 3;
        int b = 8;
    
        // int  c = a > b ? 1.1 : 3.4; // 不可以 Type mismatch
        double c = a > b ? 1.1 : 3.4; // 可以 满足 int -> double
        System.out.println(c);
    }
}
