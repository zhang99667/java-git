package chapter07;

public class MethodParameter01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        CC c = new CC();
        c.swap(a, b);
        System.out.println("主方法中：a = " + a + " b = " + b);
    }
}

class CC {
    public void swap(int a, int b) {
        System.out.println("交换前：a = " + a + " b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("交换后：a = " + a + " b = " + b);
    }
}
