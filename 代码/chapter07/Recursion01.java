package chapter07;

public class Recursion01 {
    public static void main(String[] args) {
        T t1 = new T();

        System.out.println("5! = " + t1.factorial(5));
    }
}

class T {
    public int factorial(int n) {
        if (n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
}