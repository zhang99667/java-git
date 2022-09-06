package chapter05;

public class SwatchDetail {
    public static void main(String[] args) {
        char c = 'a';
        switch (c) {
            case 'a':
                System.out.println("ok1");
                break;
            case 20:
                System.out.println("ok2");
                break;
            default:
                System.out.println("ok3");
        }
    }

}
