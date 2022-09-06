package Static_;

public class StaticDetail {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.n1);
        System.out.println(b.n2);


    }
}

class B {
    public int n1 = 100;
    public static int n2 = 200;
}

class C {
    public static String address = "北京";
}