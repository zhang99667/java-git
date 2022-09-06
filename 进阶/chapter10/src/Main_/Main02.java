package Main_;

public class Main02 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.printf("args[%d] = %s\n", (i + 1), args[i]);
        }
    }
}
