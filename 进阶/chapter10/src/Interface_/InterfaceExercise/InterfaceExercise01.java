package Interface_.InterfaceExercise;

public class InterfaceExercise01 {
    public static void main(String[] args) {
        // main中：
        B b = new B(); // ok
        System.out.println(b.a); // 23
        System.out.println(A.a); // 23
        System.out.println(B.a); // 23
    }
}

interface A {
    int a = 23; // 等价public static final int a=23;
}

class B implements A {
}// 正确
